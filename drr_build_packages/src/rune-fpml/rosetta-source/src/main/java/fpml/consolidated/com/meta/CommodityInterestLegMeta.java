package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityInterestLeg;
import fpml.consolidated.com.validation.CommodityInterestLegTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityInterestLegValidator;
import fpml.consolidated.com.validation.datarule.CommodityInterestLegChoice0;
import fpml.consolidated.com.validation.datarule.CommodityInterestLegChoice1;
import fpml.consolidated.com.validation.datarule.CommodityInterestLegChoice2;
import fpml.consolidated.com.validation.exists.CommodityInterestLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityInterestLeg.class)
public class CommodityInterestLegMeta implements RosettaMetaData<CommodityInterestLeg> {

	@Override
	public List<Validator<? super CommodityInterestLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityInterestLeg>create(CommodityInterestLegChoice0.class),
			factory.<CommodityInterestLeg>create(CommodityInterestLegChoice1.class),
			factory.<CommodityInterestLeg>create(CommodityInterestLegChoice2.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityInterestLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityInterestLeg> validator(ValidatorFactory factory) {
		return factory.<CommodityInterestLeg>create(CommodityInterestLegValidator.class);
	}

	@Override
	public Validator<? super CommodityInterestLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityInterestLeg>create(CommodityInterestLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityInterestLeg> validator() {
		return new CommodityInterestLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityInterestLeg> typeFormatValidator() {
		return new CommodityInterestLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityInterestLeg, Set<String>> onlyExistsValidator() {
		return new CommodityInterestLegOnlyExistsValidator();
	}
}
