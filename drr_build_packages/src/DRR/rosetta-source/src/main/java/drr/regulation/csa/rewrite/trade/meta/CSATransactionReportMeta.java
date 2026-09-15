package drr.regulation.csa.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.regulation.csa.rewrite.trade.validation.CSATransactionReportTypeFormatValidator;
import drr.regulation.csa.rewrite.trade.validation.CSATransactionReportValidator;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0013_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0015_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0018_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0022_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0026_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0026_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0027_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0028_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0029_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0030_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0031_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0032_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0033_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0034_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0035_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0036_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0040_01a;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0040_01b;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0041_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0042_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0043_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0044_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0045_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0046_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0047_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0048_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0049_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0053_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0054_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0055_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0056_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0057_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0058_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0068_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0069_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0070_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0071_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0076_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0095_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0098_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0099_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0100_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0111_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0112_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0113_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0114_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0115_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0116_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0120_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0135_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0136_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0137_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0141_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0142_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0143_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0144_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0145_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0147_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0002_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0003_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0016_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0017_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0017_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0019_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0019_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0023_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0026_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0026_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0026_03;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0027_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0027_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0027_03;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0033_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0033_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0034_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0034_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0040_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0040_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0041_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0041_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0042_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0042_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0045_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0053_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0053_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0054_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0054_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0055_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0055_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0069_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0069_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0070_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0070_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0071_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0071_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0100_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0136_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0137_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0142_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0142_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0142_03;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0142_04;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0143_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0143_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0143_03;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0143_04;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0144_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0147_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_03;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_04;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_05;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_07;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_08;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_10;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_11;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_12;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_13;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_14;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_18;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_19;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_20;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_23;
import drr.regulation.csa.rewrite.trade.validation.exists.CSATransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CSATransactionReport.class)
public class CSATransactionReportMeta implements RosettaMetaData<CSATransactionReport> {

	@Override
	public List<Validator<? super CSATransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0002_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0003_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0095_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0013_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0076_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0015_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0016_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0017_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0017_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0018_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0019_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0019_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0022_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0023_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0026_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0026_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0026_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0026_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0026_03.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0027_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0027_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0027_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0027_03.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0028_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0029_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0030_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0031_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0032_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0033_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0033_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0033_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0034_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0034_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0034_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0035_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0036_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0040_01a.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0040_01b.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0040_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0040_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0041_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0041_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0041_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0042_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0042_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0042_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0043_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0044_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0045_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0045_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0046_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0047_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0048_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0049_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0053_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0053_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0053_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0054_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0054_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0054_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0055_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0055_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0055_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0056_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0057_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0058_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0068_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0069_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0069_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0069_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0070_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0070_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0070_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0071_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0071_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0071_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0098_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0099_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0100_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0100_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0111_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0112_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0113_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0114_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0115_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0116_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0135_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0136_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0136_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0137_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0137_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0141_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0142_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0142_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0142_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0142_03.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0142_04.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0143_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0143_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0143_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0143_03.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0143_04.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0144_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0144_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0145_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0147_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0147_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0120_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_03.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_04.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_05.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_07.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_08.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_10.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_11.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_12.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_13.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_14.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_18.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_19.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_20.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_23.class)
		);
	}
	
	@Override
	public List<Function<? super CSATransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSATransactionReport> validator(ValidatorFactory factory) {
		return factory.<CSATransactionReport>create(CSATransactionReportValidator.class);
	}

	@Override
	public Validator<? super CSATransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSATransactionReport>create(CSATransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSATransactionReport> validator() {
		return new CSATransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSATransactionReport> typeFormatValidator() {
		return new CSATransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSATransactionReport, Set<String>> onlyExistsValidator() {
		return new CSATransactionReportOnlyExistsValidator();
	}
}
