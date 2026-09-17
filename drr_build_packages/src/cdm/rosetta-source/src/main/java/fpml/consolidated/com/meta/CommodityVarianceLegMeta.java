package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityVarianceLeg;
import fpml.consolidated.com.validation.CommodityVarianceLegTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityVarianceLegValidator;
import fpml.consolidated.com.validation.datarule.CommodityVarianceLegChoice0;
import fpml.consolidated.com.validation.datarule.CommodityVarianceLegChoice1;
import fpml.consolidated.com.validation.datarule.CommodityVarianceLegChoice2;
import fpml.consolidated.com.validation.datarule.CommodityVarianceLegChoice3;
import fpml.consolidated.com.validation.datarule.CommodityVarianceLegChoice4;
import fpml.consolidated.com.validation.exists.CommodityVarianceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityVarianceLeg.class)
public class CommodityVarianceLegMeta implements RosettaMetaData<CommodityVarianceLeg> {

	@Override
	public List<Validator<? super CommodityVarianceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityVarianceLeg>create(CommodityVarianceLegChoice0.class),
			factory.<CommodityVarianceLeg>create(CommodityVarianceLegChoice1.class),
			factory.<CommodityVarianceLeg>create(CommodityVarianceLegChoice2.class),
			factory.<CommodityVarianceLeg>create(CommodityVarianceLegChoice3.class),
			factory.<CommodityVarianceLeg>create(CommodityVarianceLegChoice4.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityVarianceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityVarianceLeg> validator(ValidatorFactory factory) {
		return factory.<CommodityVarianceLeg>create(CommodityVarianceLegValidator.class);
	}

	@Override
	public Validator<? super CommodityVarianceLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityVarianceLeg>create(CommodityVarianceLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityVarianceLeg> validator() {
		return new CommodityVarianceLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityVarianceLeg> typeFormatValidator() {
		return new CommodityVarianceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityVarianceLeg, Set<String>> onlyExistsValidator() {
		return new CommodityVarianceLegOnlyExistsValidator();
	}
}
