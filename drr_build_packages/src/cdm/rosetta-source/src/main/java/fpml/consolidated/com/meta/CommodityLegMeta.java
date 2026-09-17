package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityLeg;
import fpml.consolidated.com.validation.CommodityLegTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityLegValidator;
import fpml.consolidated.com.validation.exists.CommodityLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityLeg.class)
public class CommodityLegMeta implements RosettaMetaData<CommodityLeg> {

	@Override
	public List<Validator<? super CommodityLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityLeg> validator(ValidatorFactory factory) {
		return factory.<CommodityLeg>create(CommodityLegValidator.class);
	}

	@Override
	public Validator<? super CommodityLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityLeg>create(CommodityLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityLeg> validator() {
		return new CommodityLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityLeg> typeFormatValidator() {
		return new CommodityLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityLeg, Set<String>> onlyExistsValidator() {
		return new CommodityLegOnlyExistsValidator();
	}
}
