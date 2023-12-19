<template>
  <div class="main">
    <div class="headtext">
      <div class="textleft">年龄奖金对照</div>
      <div class="textright">公司福利情况</div>
    </div>
    <div class="up">
      <!-- 年龄--奖金 -->
      <div id="charts2" class="charts"></div>
      <!-- 福利 -->
      <div id="charts" class="charts"></div>
    </div>
    <div class="down">
      <span></span>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import { getAllInfo } from "@/api/company";
import { getAllBenefitInfo } from "@/api/benefit";
// ==== //
var echarts = require("echarts");

export default {
  name: "Dashboard",
  data() {
    return {
      ageMoneyContrast: {
        exp: [],
        salAmount: [],
      },
      benifit: {},
      benefitTotal: 0,
    };
  },
  methods: {
    async initData() {
      const _this = this;
      await getAllInfo().then((res) => {
        let target1 = _this.ageMoneyContrast.exp;
        let target2 = _this.ageMoneyContrast.salAmount;
        if (res.code == 200) {
          res.data.forEach((e) => {
            target1.push(e.exp);
            target2.push(e.salAmount);
          });
        }
      });
      await getAllBenefitInfo().then(async (res) => {
        if (res.code === 200) {
          _this.benifit = res.data;
          _this.benifit.forEach((item) => {
            this.benefitTotal += parseInt(item.value);
          });
        }
        // console.info(this.benefitTotal)
        await _this.chartsLeft();
        await _this.chartsRight();
      });
    },
    chartsLeft() {
      const _this = this;
      // 初始化echarts实例
      var myChart2 = echarts.init(document.getElementById("charts2"));
      function contains(arr, dst) {
        var i = arr.length;
        while ((i -= 1)) {
          if (arr[i] === dst) {
            return i;
          }
        }
        return false;
      }
      var option2;
      var attackSourcesColor = [
        new echarts.graphic.LinearGradient(0, 1, 1, 1, [
          { offset: 0, color: "#EB3C5A" },
          { offset: 1, color: "#FD9A5A" },
        ]),
        new echarts.graphic.LinearGradient(0, 1, 1, 1, [
          { offset: 0, color: "#EEC146" },
          { offset: 1, color: "#FD9A5A" },
        ]),
        new echarts.graphic.LinearGradient(0, 1, 1, 1, [
          { offset: 0, color: "#F7B935" },
          { offset: 1, color: "#FEEB90" },
        ]),
        new echarts.graphic.LinearGradient(0, 1, 1, 1, [
          { offset: 0, color: "#395CFD" },
          { offset: 1, color: "#2EC2D1" },
        ]),
      ];
      var attackSourcesColor1 = [
        "#EB3B5A",
        "#FA8231",
        "#F7B731",
        "#3860FC",
        "#1089E7",
        "#F57474",
        "#56D0E3",
        "#1089E7",
        "#F57474",
        "#1089E7",
        "#F57474",
        "#F57474",
      ];
      var attaData = [];
      var attaName = [];
      var topName = [];
      _this.ageMoneyContrast.exp.forEach((it, index) => {
        attaData[index] = it;
        topName[index] = `${it}年`;
      });
      _this.ageMoneyContrast.salAmount.forEach((it, index) => {
        attaName[index] = `${it}元`;
      });
      var salvProMax = []; // 背景按最大值
      for (let i = 0; i < attaData.length; i++) {
        salvProMax.push(Math.max(...attaData));
      }
      function attackSourcesDataFmt(sData) {
        var sss = [];
        sData.forEach(function (item, i) {
          const itemStyle = {
            color: i > 3 ? attackSourcesColor[3] : attackSourcesColor[i],
          };
          sss.push({
            value: item,
            itemStyle: itemStyle,
          });
        });
        return sss;
      }
      option2 = {
        backgroundColor: "#002373",
        tooltip: {
          trigger: "axis",
          axisPointer: {
            // 坐标轴指示器配置项。
            type: "none", // 'line' 直线指示器  'shadow' 阴影指示器  'none' 无指示器  'cross' 十字准星指示器。
            axis: "auto", // 指示器的坐标轴。
            snap: true, // 坐标轴指示器是否自动吸附到点上
          },
          renderMode: "html", // 浮层的渲染模式，默认以 'html 即额外的 DOM 节点展示 tooltip；
          backgroundColor: "rgba(50,50,50,0.7)", // 提示框浮层的背景颜色。
          borderColor: "#333", // 提示框浮层的边框颜色。
          borderWidth: 1, // 提示框浮层的边框宽。
          padding: 2, // 提示框浮层内边距，
          textStyle: {
            // 提示框浮层的文本样式。
            color: "#fff",
            fontStyle: "normal",
            fontWeight: "normal",
            fontFamily: "sans-serif",
            fontSize: 12,
          },
          extraCssText: "box-shadow: 0 0 3px rgba(0, 0, 0, 0.3);", // 额外附加到浮层的 css 样式
        },
        color: ["#F7B731"],
        grid: {
          left: "7%",
          right: "3%",
          width: "90%",
          bottom: "2%",
          top: "0%",
          containLabel: true,
        },
        xAxis: {
          type: "value",

          splitLine: {
            show: false,
          },
          axisLabel: {
            show: false,
          },
          axisTick: {
            show: false,
          },
          axisLine: {
            show: false,
          },
          data: topName,
        },
        yAxis: [
          {
            // 名称
            type: "category",
            offset: 36,
            position: "left",
            axisLine: {
              show: false,
            },
            inverse: true,
            axisTick: {
              show: false,
            },
            axisLabel: {
              textStyle: {
                color: function (param, index) {
                  if (index <= 2) {
                    const color = ["#F15B5A", "#EEC146", "#F7B935"];
                    return color[index];
                  } else {
                    return "#fff";
                  }
                },
              },
              show: true,
              interval: 0,
              align: "left",
              lineHeight: 32,
              fontSize: 12,
            },
            data: topName,
          },
          {
            type: "category",
            inverse: true,
            axisTick: "none",
            axisLine: "none",
            show: true,
            axisLabel: {
              textStyle: {
                color: "#fff",
                fontSize: "12",
              },
            },
            data: attackSourcesDataFmt(attaName),
          },
          {
            type: "category",
            inverse: true,
            axisLine: {
              show: false,
            },
            axisTick: {
              show: false,
            },
            axisPointer: {
              label: {
                show: false,
              },
            },
            pdaaing: [5, 0, 0, 0],
            postion: "right",
            data: attaName,
            axisLabel: {
              show: false,
              margin: 10,
              align: "left",
              color: "red",
              rich: {
                nt1: {
                  color: "#000",
                  backgroundColor: attackSourcesColor1[0],
                  width: 13,
                  height: 13,
                  fontSize: 12,
                  align: "center",
                  borderRadius: 26,
                  lineHeight: "5",
                  padding: [0, 1, 2, 1],
                },
                nt2: {
                  color: "#fff",
                  backgroundColor: attackSourcesColor1[1],
                  width: 13,
                  height: 13,
                  fontSize: 12,
                  align: "center",
                  borderRadius: 100,
                  padding: [0, 1, 2, 1],
                },
                nt3: {
                  color: "#fff",
                  backgroundColor: attackSourcesColor1[2],
                  width: 13,
                  height: 13,
                  fontSize: 12,
                  align: "center",
                  borderRadius: 100,
                  padding: [0, 1, 2, 1],
                },
                nt: {
                  color: "#fff",
                  backgroundColor: attackSourcesColor1[3],
                  width: 13,
                  height: 13,
                  fontSize: 12,
                  align: "center",
                  // lineHeight: 3,
                  borderRadius: 100,
                  padding: [0, 1, 2, 1],
                  lineHeight: 5,
                },
              },
              formatter: function (value, index) {
                index = contains(attaName, value) + 1;
                if (index - 1 < 3) {
                  return ["{nt" + index + "|" + index + "}"].join("\n");
                } else {
                  return ["{nt|" + index + "}"].join("\n");
                }
              },
            },
          },
        ],
        series: [
          {
            zlevel: 1,
            name: "",
            type: "bar",
            barWidth: "10px",
            animationDuration: 1500,
            data: attackSourcesDataFmt(attaData),
            align: "center",
            itemStyle: {
              normal: {
                barBorderRadius: 26,
              },
            },
            label: {
              show: false,
              fontSize: 12,
              color: "#fff",
              padding: [2, 0, 0, 0],
            },
          },

          {
            name: "",
            type: "bar",
            barWidth: 10,
            barGap: "-100%",
            // margin: '20',
            data: salvProMax,
            textStyle: {
              // 图例文字的样式
              fontSize: 12,
              color: "#fff",
            },
            itemStyle: {
              normal: {
                color: "#002994",
                fontSize: 12,
                barBorderRadius: 26,
              },
            },
          },
        ],
      };
      myChart2.setOption(option2);
    },
    chartsRight() {
      const _this = this;
      var myChart = echarts.init(document.getElementById("charts"));
      var color = [
        "#549BF1",
        "#AA8A6E",
        "#8F54F1",
        "#24DBDA",
        "#BCBF5C",
        "#BC5A76",
        "#67B4D4",
        "#B4C9EF",
        "#676AD4",
        "#A86EAA",
        "#5CBF7F",
        "#EFB4B4",
      ];
      var seriesData = _this.benifit; // 数据处  name-value

      var legend = [];
      // let sum = seriesData.reduce((cur, pre) => {
      //   return cur + pre.value;
      // }, 0);
      let sum = _this.benifit.length; // 总数

      seriesData.forEach((item) => {
        legend.push(item.name);
      });

      var option = {
        backgroundColor: "#050e31",
        color: color,
        title: [
          {
            text: "福利总数",
            top: "45%",
            left: "34%",
            textStyle: {
              color: "#16ffff",
              fontSize: 24,
              fontWeight: "bold",
              textAlign: "center",
            },
          },
          {
            text: sum + "个",
            top: "51.5%",
            left: "35.4%",
            textStyle: {
              color: "#16ffff",
              fontSize: 28,
              fontWeight: "400",
              textAlign: "center",
            },
          },
        ],
        polar: {
          center: ["40%", "50%"],
          radius: ["26%", "60%"],
        }, //环线
        angleAxis: {},
        radiusAxis: {
          min: 50,
          max: 70,
          interval: 20,
          // splitNumber: 3,
          axisLine: {
            show: false,
            lineStyle: {
              color: "#0B3E5E",
              width: 1,
              type: "solid",
            },
          },
          axisLabel: {
            formatter: "{value} %",
            show: false,
            padding: [0, 0, 0, 0],
            color: "#0B3E5E",
            fontSize: 16,
          },
          splitLine: {
            lineStyle: {
              color: "#0B3E5E",
              width: 2,
              type: "solid",
            },
          },
        },
        legend: {
          itemHeight: 12,
          itemWidth: 12,
          icon: "rect",
          orient: "vertical",
          top: "center",
          right: "5%",
          itemGap: 20,
          textStyle: {
            align: "left",
            verticalAlign: "middle",
            rich: {
              name: {
                color: "rgba(255,255,255,0.5)",
                fontSize: 14,
              },
              value: {
                color: "rgba(255,255,255,0.5)",
                fontSize: 14,
              },
              rate: {
                color: "rgba(255,255,255,0.9)",
                fontSize: 14,
              },
            },
          },
          data: legend,
          formatter: (name) => {
            if (seriesData.length) {
              const item = seriesData.filter((item) => item.name === name)[0];
              // 百分百: 总金额/每一份的金额
              // let percent = ((item.value / sum) * 100).toFixed(2);
              let percent = ((item.value / this.benefitTotal) * 100).toFixed(2);
              // console.info("total:"+ this.benefitTotal)
              return `{name|${name}} {name|${item.value}元} {rate|${percent}%}`;
            }
          },
        },
        series: [
          {
            name: "ring5",
            type: "custom",
            coordinateSystem: "none",
            renderItem: function (params, api) {
              return {
                type: "arc",
                shape: {
                  cx: api.getWidth() * 0.4,
                  cy: api.getHeight() / 2,
                  r: Math.min(api.getWidth(), api.getHeight()) / 2.4,
                  startAngle: ((0 + angle) * Math.PI) / 180,
                  endAngle: ((80 + angle) * Math.PI) / 180,
                },
                style: {
                  stroke: "#4680e0",
                  fill: "transparent",
                  lineWidth: 2,
                },
                silent: true,
              };
            },
            data: [0],
          },
          {
            name: "ring5",
            type: "custom",
            coordinateSystem: "none",
            renderItem: function (params, api) {
              return {
                type: "arc",
                shape: {
                  cx: api.getWidth() * 0.4,
                  cy: api.getHeight() / 2,
                  r: Math.min(api.getWidth(), api.getHeight()) / 2.4,
                  startAngle: ((85 + angle) * Math.PI) / 180,
                  endAngle: ((165 + angle) * Math.PI) / 180,
                },
                style: {
                  stroke: "#4680e0",
                  fill: "transparent",
                  lineWidth: 2,
                },
                silent: true,
              };
            },
            data: [0],
          },
          {
            name: "ring5",
            type: "custom",
            coordinateSystem: "none",
            renderItem: function (params, api) {
              return {
                type: "arc",
                shape: {
                  cx: api.getWidth() * 0.4,
                  cy: api.getHeight() / 2,
                  r: Math.min(api.getWidth(), api.getHeight()) / 2.4,
                  startAngle: ((170 + angle) * Math.PI) / 180,
                  endAngle: ((250 + angle) * Math.PI) / 180,
                },
                style: {
                  stroke: "#4680e0",
                  fill: "transparent",
                  lineWidth: 2,
                },
                silent: true,
              };
            },
            data: [0],
          },
          {
            name: "ring5",
            type: "custom",
            coordinateSystem: "none",
            renderItem: function (params, api) {
              return {
                type: "arc",
                shape: {
                  cx: api.getWidth() * 0.4,
                  cy: api.getHeight() / 2,
                  r: Math.min(api.getWidth(), api.getHeight()) / 2.4,
                  startAngle: ((255 + angle) * Math.PI) / 180,
                  endAngle: ((335 + angle) * Math.PI) / 180,
                },
                style: {
                  stroke: "#4680e0",
                  fill: "transparent",
                  lineWidth: 2,
                },
                silent: true,
              };
            },
            data: [0],
          },
          {
            name: "ring5",
            type: "custom",
            coordinateSystem: "none",
            renderItem: function (params, api) {
              return {
                type: "arc",
                shape: {
                  cx: api.getWidth() * 0.4,
                  cy: api.getHeight() / 2,
                  r: Math.min(api.getWidth(), api.getHeight()) / 2.4,
                  startAngle: ((340 + angle) * Math.PI) / 180,
                  endAngle: ((355 + angle) * Math.PI) / 180,
                },
                style: {
                  stroke: "#4680e0",
                  fill: "transparent",
                  lineWidth: 2,
                },
                silent: true,
              };
            },
            data: [0],
          },

          {
            name: "ring5",
            type: "custom",
            coordinateSystem: "none",
            renderItem: function (params, api) {
              return {
                type: "arc",
                shape: {
                  cx: api.getWidth() * 0.4,
                  cy: api.getHeight() / 2,
                  r: Math.min(api.getWidth(), api.getHeight()) / 2.8,
                  startAngle: ((0 + angle) * Math.PI) / 180,
                  endAngle: ((60 + angle) * Math.PI) / 180,
                },
                style: {
                  stroke: "#4680e0",
                  fill: "transparent",
                  lineWidth: 2,
                },
                silent: true,
              };
            },
            data: [0],
          },
          {
            name: "ring5",
            type: "custom",
            coordinateSystem: "none",
            renderItem: function (params, api) {
              return {
                type: "arc",
                shape: {
                  cx: api.getWidth() * 0.4,
                  cy: api.getHeight() / 2,
                  r: Math.min(api.getWidth(), api.getHeight()) / 2.8,
                  startAngle: ((70 + angle) * Math.PI) / 180,
                  endAngle: ((130 + angle) * Math.PI) / 180,
                },
                style: {
                  stroke: "#4680e0",
                  fill: "transparent",
                  lineWidth: 2,
                },
                silent: true,
              };
            },
            data: [0],
          },
          {
            name: "ring5",
            type: "custom",
            coordinateSystem: "none",
            renderItem: function (params, api) {
              return {
                type: "arc",
                shape: {
                  cx: api.getWidth() * 0.4,
                  cy: api.getHeight() / 2,
                  r: Math.min(api.getWidth(), api.getHeight()) / 2.8,
                  startAngle: ((140 + angle) * Math.PI) / 180,
                  endAngle: ((200 + angle) * Math.PI) / 180,
                },
                style: {
                  stroke: "#4680e0",
                  fill: "transparent",
                  lineWidth: 2,
                },
                silent: true,
              };
            },
            data: [0],
          },
          {
            name: "ring5",
            type: "custom",
            coordinateSystem: "none",
            renderItem: function (params, api) {
              return {
                type: "arc",
                shape: {
                  cx: api.getWidth() * 0.4,
                  cy: api.getHeight() / 2,
                  r: Math.min(api.getWidth(), api.getHeight()) / 2.8,
                  startAngle: ((210 + angle) * Math.PI) / 180,
                  endAngle: ((270 + angle) * Math.PI) / 180,
                },
                style: {
                  stroke: "#4680e0",
                  fill: "transparent",
                  lineWidth: 2,
                },
                silent: true,
              };
            },
            data: [0],
          },
          {
            name: "ring5",
            type: "custom",
            coordinateSystem: "none",
            renderItem: function (params, api) {
              return {
                type: "arc",
                shape: {
                  cx: api.getWidth() * 0.4,
                  cy: api.getHeight() / 2,
                  r: Math.min(api.getWidth(), api.getHeight()) / 2.8,
                  startAngle: ((280 + angle) * Math.PI) / 180,
                  endAngle: ((350 + angle) * Math.PI) / 180,
                },
                style: {
                  stroke: "#4680e0",
                  fill: "transparent",
                  lineWidth: 2,
                },
                silent: true,
              };
            },
            data: [0],
          },
          {
            name: "占比",
            type: "pie",
            center: ["40%", "50%"],
            radius: ["30%", "50%"],
            label: {
              normal: {
                show: false,
                position: "center",
                formatter: "{value|{c}}\n{label|{b}}",
                rich: {
                  //中间文字
                  value: {
                    padding: 5,
                    align: "center",
                    verticalAlign: "middle",
                    fontSize: 20,
                  },
                  label: {
                    align: "center",
                    verticalAlign: "middle",
                    fontSize: 16,
                  },
                },
              },
            },
            labelLine: {
              show: false,
              length: 0,
              length2: 0,
            },
            itemStyle: {
              //间隔
              normal: {
                borderWidth: 3,
                borderColor: "#050e31",
              },
            },
            data: seriesData,
          },
        ],
      };

      // ===TODO===
      let angle = 0; //角度，用来做简单的动画效果的
      function draw() {
        angle = angle + 3;
        option && myChart.setOption(option, true);
      }
      setInterval(function () {
        //用setInterval做动画感觉有问题
        draw();
      }, 500);
    },
    showWelcome() {
      this.$notify.success({
        title: "",
        message: "欢迎您: " + this.name,
        duration: 2000,
      });
    },
  },
  mounted() {
    this.showWelcome();
    this.initData();
  },
  computed: {
    ...mapGetters(["name"]),
  },
};
</script>

<style lang="scss" scoped>
.main {
  .headtext{
    display: flex;
    font-size: 20px;
    color: red;
    .textleft {
      left: 0;
      margin-left: 23%;
      text-align: left;
    }
    .textright {
      right: 0;
      margin-left: 37%;
      text-align: right;
    }
  }
  .up {
    display: flex;
    .charts {
      margin-left: 1%;
      margin-top: 1%;
      height: 570px;
      width: 800px;
    }
  }
  .down{
    margin-top: 1%;
    margin-left: 1%;
  }
}
</style>
