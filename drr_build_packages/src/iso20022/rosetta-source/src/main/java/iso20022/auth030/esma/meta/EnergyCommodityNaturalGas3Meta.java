package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.EnergyCommodityNaturalGas3;
import iso20022.auth030.esma.validation.EnergyCommodityNaturalGas3TypeFormatValidator;
import iso20022.auth030.esma.validation.EnergyCommodityNaturalGas3Validator;
import iso20022.auth030.esma.validation.exists.EnergyCommodityNaturalGas3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnergyCommodityNaturalGas3.class)
public class EnergyCommodityNaturalGas3Meta implements RosettaMetaData<EnergyCommodityNaturalGas3> {

	@Override
	public List<Validator<? super EnergyCommodityNaturalGas3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnergyCommodityNaturalGas3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnergyCommodityNaturalGas3> validator(ValidatorFactory factory) {
		return factory.<EnergyCommodityNaturalGas3>create(EnergyCommodityNaturalGas3Validator.class);
	}

	@Override
	public Validator<? super EnergyCommodityNaturalGas3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnergyCommodityNaturalGas3>create(EnergyCommodityNaturalGas3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityNaturalGas3> validator() {
		return new EnergyCommodityNaturalGas3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityNaturalGas3> typeFormatValidator() {
		return new EnergyCommodityNaturalGas3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnergyCommodityNaturalGas3, Set<String>> onlyExistsValidator() {
		return new EnergyCommodityNaturalGas3OnlyExistsValidator();
	}
}
