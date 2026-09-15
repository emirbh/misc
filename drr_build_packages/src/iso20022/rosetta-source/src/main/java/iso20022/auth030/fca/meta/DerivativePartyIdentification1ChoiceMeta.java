package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.DerivativePartyIdentification1Choice;
import iso20022.auth030.fca.validation.DerivativePartyIdentification1ChoiceTypeFormatValidator;
import iso20022.auth030.fca.validation.DerivativePartyIdentification1ChoiceValidator;
import iso20022.auth030.fca.validation.datarule.DerivativePartyIdentification1ChoiceChoice;
import iso20022.auth030.fca.validation.exists.DerivativePartyIdentification1ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativePartyIdentification1Choice.class)
public class DerivativePartyIdentification1ChoiceMeta implements RosettaMetaData<DerivativePartyIdentification1Choice> {

	@Override
	public List<Validator<? super DerivativePartyIdentification1Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DerivativePartyIdentification1Choice>create(DerivativePartyIdentification1ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DerivativePartyIdentification1Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativePartyIdentification1Choice> validator(ValidatorFactory factory) {
		return factory.<DerivativePartyIdentification1Choice>create(DerivativePartyIdentification1ChoiceValidator.class);
	}

	@Override
	public Validator<? super DerivativePartyIdentification1Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativePartyIdentification1Choice>create(DerivativePartyIdentification1ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativePartyIdentification1Choice> validator() {
		return new DerivativePartyIdentification1ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativePartyIdentification1Choice> typeFormatValidator() {
		return new DerivativePartyIdentification1ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativePartyIdentification1Choice, Set<String>> onlyExistsValidator() {
		return new DerivativePartyIdentification1ChoiceOnlyExistsValidator();
	}
}
