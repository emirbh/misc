package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.EnergyDeliveryAttribute10__1;
import iso20022.auth030.esma.validation.EnergyDeliveryAttribute10__1TypeFormatValidator;
import iso20022.auth030.esma.validation.EnergyDeliveryAttribute10__1Validator;
import iso20022.auth030.esma.validation.exists.EnergyDeliveryAttribute10__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnergyDeliveryAttribute10__1.class)
public class EnergyDeliveryAttribute10__1Meta implements RosettaMetaData<EnergyDeliveryAttribute10__1> {

	@Override
	public List<Validator<? super EnergyDeliveryAttribute10__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnergyDeliveryAttribute10__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnergyDeliveryAttribute10__1> validator(ValidatorFactory factory) {
		return factory.<EnergyDeliveryAttribute10__1>create(EnergyDeliveryAttribute10__1Validator.class);
	}

	@Override
	public Validator<? super EnergyDeliveryAttribute10__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnergyDeliveryAttribute10__1>create(EnergyDeliveryAttribute10__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnergyDeliveryAttribute10__1> validator() {
		return new EnergyDeliveryAttribute10__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnergyDeliveryAttribute10__1> typeFormatValidator() {
		return new EnergyDeliveryAttribute10__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnergyDeliveryAttribute10__1, Set<String>> onlyExistsValidator() {
		return new EnergyDeliveryAttribute10__1OnlyExistsValidator();
	}
}
