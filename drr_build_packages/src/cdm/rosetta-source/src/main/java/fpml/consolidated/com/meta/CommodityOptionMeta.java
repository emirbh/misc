package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.com.validation.CommodityOptionTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityOptionValidator;
import fpml.consolidated.com.validation.datarule.CommodityOptionChoice0;
import fpml.consolidated.com.validation.datarule.CommodityOptionChoice1;
import fpml.consolidated.com.validation.datarule.CommodityOptionChoice2;
import fpml.consolidated.com.validation.datarule.CommodityOptionChoice3;
import fpml.consolidated.com.validation.datarule.CommodityOptionChoice4;
import fpml.consolidated.com.validation.datarule.CommodityOptionChoice5;
import fpml.consolidated.com.validation.datarule.CommodityOptionChoice6;
import fpml.consolidated.com.validation.datarule.CommodityOptionChoice7;
import fpml.consolidated.com.validation.datarule.CommodityOptionChoice8;
import fpml.consolidated.com.validation.exists.CommodityOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityOption.class)
public class CommodityOptionMeta implements RosettaMetaData<CommodityOption> {

	@Override
	public List<Validator<? super CommodityOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityOption>create(CommodityOptionChoice0.class),
			factory.<CommodityOption>create(CommodityOptionChoice1.class),
			factory.<CommodityOption>create(CommodityOptionChoice2.class),
			factory.<CommodityOption>create(CommodityOptionChoice3.class),
			factory.<CommodityOption>create(CommodityOptionChoice4.class),
			factory.<CommodityOption>create(CommodityOptionChoice5.class),
			factory.<CommodityOption>create(CommodityOptionChoice6.class),
			factory.<CommodityOption>create(CommodityOptionChoice7.class),
			factory.<CommodityOption>create(CommodityOptionChoice8.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityOption> validator(ValidatorFactory factory) {
		return factory.<CommodityOption>create(CommodityOptionValidator.class);
	}

	@Override
	public Validator<? super CommodityOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityOption>create(CommodityOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityOption> validator() {
		return new CommodityOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityOption> typeFormatValidator() {
		return new CommodityOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityOption, Set<String>> onlyExistsValidator() {
		return new CommodityOptionOnlyExistsValidator();
	}
}
