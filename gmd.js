/**
 * 使用该脚本自动生成readme.md的文件规则
 * 在每个题目文件下第一行为该文件名称的注释
 * 如： //9.Fizz Buzz 问题 / fizz-buzz (java)
 *      # 9.Fizz Buzz 问题 / fizz-buzz (python)
 * 每个题目文件的第二行为该题目的原地址链接
 * 如： //http://www.lintcode.com/problem/fizz-buzz (java)
 *      # http://www.lintcode.com/problem/fizz-buzz (python)
 */

'use strict';

let fs = require('fs');
let path = require('path');
let readline = require('readline');

const FILENAME_REG = /^(\d+).[-0-9a-zA-Z]+.(java|py)$/;
const URL_REG = /https?:\/\/www.lintcode.com\/(zh-cn\/)?problem\/[-0-9a-zA-Z]+/;
const JAVA_URL = 'https://github.com/t2krew/lintcode-solution/blob/master/';
const PYTHON_URL = 'https://github.com/t2krew/lintcode-solution/blob/master/python/';
const PROBLEM_URL = 'http://www.lintcode.com/zh-cn/problem';

let items = {};

/**
 * 遍历目录下的题目文件
 * @param {String} root 根目录
 */
;(function readSolution(root) {
  let result = fs.readdirSync(root);
  result.forEach((ele) => {
    let cpath = path.join(root, ele);
    try {
      let stats = fs.lstatSync(cpath);
      if (stats.isFile()) {
        let match = ele.match(FILENAME_REG);
        if (match) {
          if (!items[match[1]]) items[match[1]] = [];
          if (match[2] == 'java') {
            items[match[1]][0] = JAVA_URL + ele;
          } else {
            items[match[1]][1] = PYTHON_URL + ele;
          }
          let content = fs.readFileSync(cpath, 'utf8').split('\n');
          let name = content[0];
          items[match[1]][2] = name.replace(/^(\/\/|#)/, '') || '';
          let url = content[1];
          items[match[1]][3] = URL_REG.test(url)? url.replace(/^(\/\/|#)/, '') : PROBLEM_URL;
        }
      } else if (stats.isDirectory()) {
        readSolution(cpath);
      }
    } catch(err) {
      console.error(err);
    }
  });
})(__dirname);


let keys = Object.keys(items).sort((a, b) => {
  return a - b;
});

//readme.md 公共头部
let header = '# lintcode-solution\n' + 
              '***[Lintcode](http://www.lintcode.com)题目解法，当前题目数量：' + Object.keys(items).length + '***\n' +
              '<br/>\n' + 
              '<br/>\n';

keys.forEach((ele) => {
  header += '-\t[' + items[ele][2] + '](' + items[ele][3] + ')' +
            ' ==> ' +
            (items[ele][0]? '(<a href="' + items[ele][0] + '" target="_blank">Java solution</a>' : '<span>Java solution</span>') +
            ' - ' + 
            (items[ele][1] ? '<a href="' + items[ele][1] + '" target="_blank">Python solution</a>)\n' : '<span>Python solution</span>)\n');
});

try {
  fs.writeFileSync(path.join(__dirname, 'README.md'), header, 'utf8');
} catch(err) {
  console.error(err);
}