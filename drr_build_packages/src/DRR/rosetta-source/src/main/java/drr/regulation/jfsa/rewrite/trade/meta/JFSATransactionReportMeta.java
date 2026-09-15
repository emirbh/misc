package drr.regulation.jfsa.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.regulation.jfsa.rewrite.trade.validation.JFSATransactionReportTypeFormatValidator;
import drr.regulation.jfsa.rewrite.trade.validation.JFSATransactionReportValidator;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0001a_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0001b_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0001c_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0002_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0002a_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0002b_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0003_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0003b_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0004_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0004_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0007_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0008_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0010_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0011_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0011_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0013_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0016_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0017_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0018_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0019_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0020_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0021_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0022_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0023_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0024_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0024_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0025_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0026_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0027_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0027_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0027_03;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0027_04;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0028_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0028_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0028_03;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0028_04;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0029_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0029_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0029_03;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0029_04;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0031_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0031_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0032_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0032_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0033_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0033_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0034_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0035_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0036_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0037_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0038_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0062_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0063_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0063_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0064_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0065_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0066_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0067_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0068_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0069_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0070_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0071_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0071_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0073_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0073_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0074_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0074_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0075_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0076_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0076_01b;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0077_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0078_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0079_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0080_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0081_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0082_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0083_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0085_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0087_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0087_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0090_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0090_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0091_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0092_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0093_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0093_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0094_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0094_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0095_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0095_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0096_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0096_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0097_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0097_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0097_03;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0098_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0098_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0099_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0099_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0100_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0100_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0101_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0102_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0103_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0104_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0104_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0104_03;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0105_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0110_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0110_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0110_03;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0110_04;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0111_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0111_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0112_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0113_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0113_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0114_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0115_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0115_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0116_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0116_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0117_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0117_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0118_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0118_02;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0120_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0121_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0122_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0123_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0124_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0125_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0127_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0128_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0133_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0134_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0135_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0136_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0137_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportDTCC_JFSA_BR_0138_01;
import drr.regulation.jfsa.rewrite.trade.validation.datarule.JFSATransactionReportGlobalUTIRequired;
import drr.regulation.jfsa.rewrite.trade.validation.exists.JFSATransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=JFSATransactionReport.class)
public class JFSATransactionReportMeta implements RosettaMetaData<JFSATransactionReport> {

	@Override
	public List<Validator<? super JFSATransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0002_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0003_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0004_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0004_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0007_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0008_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0010_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0011_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0011_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0013_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0016_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0017_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0018_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0019_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0020_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0021_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0022_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0023_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0024_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0024_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0025_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportGlobalUTIRequired.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0026_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0027_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0027_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0027_03.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0027_04.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0028_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0028_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0028_03.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0028_04.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0029_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0029_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0029_03.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0029_04.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0031_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0031_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0032_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0032_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0033_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0033_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0034_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0035_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0036_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0037_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0038_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0062_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0063_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0063_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0064_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0065_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0066_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0067_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0068_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0069_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0070_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0071_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0071_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0073_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0073_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0074_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0074_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0075_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0076_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0076_01b.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0077_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0078_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0079_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0080_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0081_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0082_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0083_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0085_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0087_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0087_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0090_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0090_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0091_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0092_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0093_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0093_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0094_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0094_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0095_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0095_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0096_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0096_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0097_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0097_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0097_03.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0098_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0098_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0099_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0099_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0100_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0100_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0101_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0102_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0103_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0104_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0104_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0104_03.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0105_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0110_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0110_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0110_03.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0110_04.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0111_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0111_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0112_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0113_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0113_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0114_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0115_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0115_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0116_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0116_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0117_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0117_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0118_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0118_02.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0120_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0121_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0122_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0123_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0124_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0125_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0127_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0128_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0133_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0134_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0135_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0136_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0137_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0138_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0001a_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0001b_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0001c_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0002a_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0002b_01.class),
			factory.<JFSATransactionReport>create(JFSATransactionReportDTCC_JFSA_BR_0003b_01.class)
		);
	}
	
	@Override
	public List<Function<? super JFSATransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super JFSATransactionReport> validator(ValidatorFactory factory) {
		return factory.<JFSATransactionReport>create(JFSATransactionReportValidator.class);
	}

	@Override
	public Validator<? super JFSATransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<JFSATransactionReport>create(JFSATransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super JFSATransactionReport> validator() {
		return new JFSATransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super JFSATransactionReport> typeFormatValidator() {
		return new JFSATransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super JFSATransactionReport, Set<String>> onlyExistsValidator() {
		return new JFSATransactionReportOnlyExistsValidator();
	}
}
