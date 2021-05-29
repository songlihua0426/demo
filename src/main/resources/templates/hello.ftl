<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title></title>
    <style type="text/css">
        body {
            font-family: pingfang sc light;
        }

        .center {
            text-align: center;
            width: 100%;
        }
    </style>
</head>
<body>
<!--第一页开始-->
<div class="page">
    <div class="center"><H1>评估报告模板</H1></div>
    <div class="center"><p>生成时间${createDate}</p></div>
    <div>
        <H1>一、项目概况</H1>
        <H2>项目名称:${projectName}</H2>
        <H2>项目说明:</H2>
        <table>
            <tr>
                <td>项目区域</td>
                <td>${area}</td>
            </tr>
            <tr>
                <td>地形地貌</td>
                <td>${topography}</td>
            </tr>
            <tr>
                <td>系统规模</td>
                <td>${scale}</td>
            </tr>
        </table>
    </div>

    <div>
        <H1>二、系统设计</H1>
        <H2>1、系统整体配置方案</H2>
        <table>
            <tr>
                <td>系统组件</td>
                <td>数量</td>
                <td>数据来源标志位</td>
            </tr>
            <#list systemConfig as config>
                <tr>
                    <td>${config.device}</td>
                    <td>${config.num}</td>
                    <td>${config.flag}</td>
                </tr>
            </#list>
        </table>
    </div>

    <div>
        <H2>2、项目运行参数配置：</H2>
        <table>
            <tr>
                <#--<#if myOptionalVar??>when-present<#else>when-missing</#if>-->
                <td>项目周期（年）</td>
                <td>${projectRunConfig.projectCycle}</td>
            </tr>
            <tr>
                <td>运行模式</td>
                <td>${projectRunConfig.evaluationMode}</td>
            </tr>
            <tr>
                <td>电价补贴（元/kWh）</td>
                <td>${projectRunConfig.electricityPriceSubsidy}</td>
            </tr>
            <tr>
                <td>增值税税率（%）</td>
                <td>${projectRunConfig.vatRate}</td>
            </tr>
            <tr>
                <td>资本金比例</td>
                <td>${projectRunConfig.capitalRatio}</td>
            </tr>
            <tr>
                <td>长期贷款利率</td>
                <td>${projectRunConfig.longLendingRates}</td>
            </tr>
            <tr>
                <td>短期贷款利率</td>
                <td>${projectRunConfig.shortLendingRates}</td>
            </tr>
            <tr>
                <td>预定还款期</td>
                <td>${projectRunConfig.preRepaymentYear}</td>
            </tr>
            <tr>
                <td>自有流动资金比例</td>
                <td>${projectRunConfig.ownWorkingCapital}</td>
            </tr>
            <tr>
                <td>企业所得税率</td>
                <td>${projectRunConfig.corporateIncomeTax}</td>
            </tr>
        </table>
    </div>
</div>
<!--第一页结束-->
<!---分页标记-->
<span style="page-break-after:always;"></span>
<!--第二页开始-->
<div class="page">
    <div>
        <H2>3、设备具体参数：</H2>
        <#list equipment as item>
            <h3>${item.device}</h3>
            <table>
                <#list item.params as param>
                    <tr>
                        <td>${param.key}</td>
                        <td>${param.value}</td>
                    </tr>
                </#list>
            </table>
        </#list>
    </div>

    <div>
        <h2>三、评估指标</h2>

        <table>
            <tr>
                <td>项目初始投资成本（万元）</td>
                <td>${evaluationIndex.economy1} </td>
            </tr>
            <tr>
                <td>项目投资回收周期（年）</td>
                <td>${evaluationIndex.economy2} </td>
            </tr>
            <tr>
                <td>项目投资财产内部收益率（%）</td>
                <td>${evaluationIndex.economy3} </td>
            </tr>
        </table>
    </div>

    <div>
        <h2>四、系统运行：</h2>

        <#list equipment as item>
            <h3>${item.device}</h3>
            <table>
                <#list item.systemRunParam as param>
                    <tr>
                        <td>${param.key}</td>
                        <td>${param.value}</td>
                    </tr>
                </#list>
            </table>
        </#list>
    </div>

</div>


<!--第二页结束-->
</body>
</html>