package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityReturnLeg;
import fpml.consolidated.com.validation.CommodityReturnLegTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityReturnLegValidator;
import fpml.consolidated.com.validation.datarule.CommodityReturnLegChoice0;
import fpml.consolidated.com.validation.datarule.CommodityReturnLegChoice1;
import fpml.consolidated.com.validation.datarule.CommodityReturnLegChoice2;
import fpml.consolidated.com.validation.datarule.CommodityReturnLegChoice3;
import fpml.consolidated.com.validation.exists.CommodityReturnLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityReturnLeg.class)
public class CommodityReturnLegMeta implements RosettaMetaData<CommodityReturnLeg> {

	@Override
	public List<Validator<? super CommodityReturnLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityReturnLeg>create(CommodityReturnLegChoice0.class),
			factory.<CommodityReturnLeg>create(CommodityReturnLegChoice1.class),
			factory.<CommodityReturnLeg>create(CommodityReturnLegChoice2.class),
			factory.<CommodityReturnLeg>create(CommodityReturnLegChoice3.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityReturnLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityReturnLeg> validator(ValidatorFactory factory) {
		return factory.<CommodityReturnLeg>create(CommodityReturnLegValidator.class);
	}

	@Override
	public Validator<? super CommodityReturnLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityReturnLeg>create(CommodityReturnLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityReturnLeg> validator() {
		return new CommodityReturnLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityReturnLeg> typeFormatValidator() {
		return new CommodityReturnLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityReturnLeg, Set<String>> onlyExistsValidator() {
		return new CommodityReturnLegOnlyExistsValidator();
	}
}
