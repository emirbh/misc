package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.EnergySpecificAttribute9__1;
import iso20022.auth030.fca.validation.EnergySpecificAttribute9__1TypeFormatValidator;
import iso20022.auth030.fca.validation.EnergySpecificAttribute9__1Validator;
import iso20022.auth030.fca.validation.exists.EnergySpecificAttribute9__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnergySpecificAttribute9__1.class)
public class EnergySpecificAttribute9__1Meta implements RosettaMetaData<EnergySpecificAttribute9__1> {

	@Override
	public List<Validator<? super EnergySpecificAttribute9__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnergySpecificAttribute9__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnergySpecificAttribute9__1> validator(ValidatorFactory factory) {
		return factory.<EnergySpecificAttribute9__1>create(EnergySpecificAttribute9__1Validator.class);
	}

	@Override
	public Validator<? super EnergySpecificAttribute9__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnergySpecificAttribute9__1>create(EnergySpecificAttribute9__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnergySpecificAttribute9__1> validator() {
		return new EnergySpecificAttribute9__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnergySpecificAttribute9__1> typeFormatValidator() {
		return new EnergySpecificAttribute9__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnergySpecificAttribute9__1, Set<String>> onlyExistsValidator() {
		return new EnergySpecificAttribute9__1OnlyExistsValidator();
	}
}
