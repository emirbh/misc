package drr.regulation.hkma.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.regulation.hkma.rewrite.trade.validation.HKMATransactionReportTypeFormatValidator;
import drr.regulation.hkma.rewrite.trade.validation.HKMATransactionReportValidator;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0001;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0002;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0003;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0004;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0005;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0006;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0007;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0008;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0009;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0010;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0011;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0012;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0013;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0014;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0015;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0016;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0018;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0020;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0021;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0026;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0027;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0028;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0029;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0030;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0031;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0032;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0033;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0034;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0035;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0036;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0037;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0046;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0054;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0062;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0063;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0064;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0065;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0068;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0069;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0076;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0077;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0080;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0081;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0084;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0085;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0086;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0087;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0088;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0089;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0092;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0095;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0096;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0097;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0098;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0099;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0100;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0101;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0114;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0115;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0117;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0119;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0120;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0121;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0122;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0136;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0137;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0138;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportDOC0139;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportGlobalUTIRequired;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportSRI0001;
import drr.regulation.hkma.rewrite.trade.validation.datarule.HKMATransactionReportUtiRequired;
import drr.regulation.hkma.rewrite.trade.validation.exists.HKMATransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=HKMATransactionReport.class)
public class HKMATransactionReportMeta implements RosettaMetaData<HKMATransactionReport> {

	@Override
	public List<Validator<? super HKMATransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0001.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0139.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0002.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0003.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0004.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0005.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0006.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0007.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0008.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0009.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0010.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0011.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0012.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0013.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0014.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0015.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0016.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0018.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0020.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0021.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0026.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0027.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0028.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0029.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0030.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0031.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0032.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0033.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0034.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0035.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0036.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0037.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0046.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0054.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0062.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0063.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0064.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0065.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0068.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0069.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0076.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0077.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0080.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0081.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0084.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0085.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0086.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0087.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0088.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0089.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0092.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0012.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0095.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0138.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0096.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0097.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0098.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0099.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0100.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0101.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0137.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0114.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0115.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0136.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0012.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0117.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0119.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0120.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0121.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportDOC0122.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportSRI0001.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportUtiRequired.class),
			factory.<HKMATransactionReport>create(HKMATransactionReportGlobalUTIRequired.class)
		);
	}
	
	@Override
	public List<Function<? super HKMATransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super HKMATransactionReport> validator(ValidatorFactory factory) {
		return factory.<HKMATransactionReport>create(HKMATransactionReportValidator.class);
	}

	@Override
	public Validator<? super HKMATransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<HKMATransactionReport>create(HKMATransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super HKMATransactionReport> validator() {
		return new HKMATransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super HKMATransactionReport> typeFormatValidator() {
		return new HKMATransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super HKMATransactionReport, Set<String>> onlyExistsValidator() {
		return new HKMATransactionReportOnlyExistsValidator();
	}
}
