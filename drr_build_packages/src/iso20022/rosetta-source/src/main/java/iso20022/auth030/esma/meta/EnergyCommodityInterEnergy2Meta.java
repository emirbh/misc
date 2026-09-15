package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.EnergyCommodityInterEnergy2;
import iso20022.auth030.esma.validation.EnergyCommodityInterEnergy2TypeFormatValidator;
import iso20022.auth030.esma.validation.EnergyCommodityInterEnergy2Validator;
import iso20022.auth030.esma.validation.exists.EnergyCommodityInterEnergy2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnergyCommodityInterEnergy2.class)
public class EnergyCommodityInterEnergy2Meta implements RosettaMetaData<EnergyCommodityInterEnergy2> {

	@Override
	public List<Validator<? super EnergyCommodityInterEnergy2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnergyCommodityInterEnergy2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnergyCommodityInterEnergy2> validator(ValidatorFactory factory) {
		return factory.<EnergyCommodityInterEnergy2>create(EnergyCommodityInterEnergy2Validator.class);
	}

	@Override
	public Validator<? super EnergyCommodityInterEnergy2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnergyCommodityInterEnergy2>create(EnergyCommodityInterEnergy2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityInterEnergy2> validator() {
		return new EnergyCommodityInterEnergy2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityInterEnergy2> typeFormatValidator() {
		return new EnergyCommodityInterEnergy2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnergyCommodityInterEnergy2, Set<String>> onlyExistsValidator() {
		return new EnergyCommodityInterEnergy2OnlyExistsValidator();
	}
}
