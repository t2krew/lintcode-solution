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
let header = '# lintcode-solution\n' + 
                'Lintcode题目解法 http://www.lintcode.com/\n' +
                '<br/>\n' + 
                '<br/>\n'

function readSolution(root) {
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
}


readSolution(__dirname);

let keys = Object.keys(items).sort((a, b) => {
  return a - b;
});

keys.forEach((ele) => {
  header += '-\t[' + items[ele][2] + '](' + items[ele][3] + ')' +
            ' ==> ' +
            '[[Java solution](' + items[ele][0] + ')' +
            ' - ' + 
            '[Python solution](' + items[ele][1] + ')]\n';
});

try {
  fs.writeFileSync(path.join(__dirname, 'README.md'), header, 'utf8');
} catch(err) {
  console.error(err);
}