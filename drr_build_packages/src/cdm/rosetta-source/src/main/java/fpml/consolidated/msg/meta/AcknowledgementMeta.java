package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.Acknowledgement;
import fpml.consolidated.msg.validation.AcknowledgementTypeFormatValidator;
import fpml.consolidated.msg.validation.AcknowledgementValidator;
import fpml.consolidated.msg.validation.exists.AcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Acknowledgement.class)
public class AcknowledgementMeta implements RosettaMetaData<Acknowledgement> {

	@Override
	public List<Validator<? super Acknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Acknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Acknowledgement> validator(ValidatorFactory factory) {
		return factory.<Acknowledgement>create(AcknowledgementValidator.class);
	}

	@Override
	public Validator<? super Acknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Acknowledgement>create(AcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Acknowledgement> validator() {
		return new AcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Acknowledgement> typeFormatValidator() {
		return new AcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Acknowledgement, Set<String>> onlyExistsValidator() {
		return new AcknowledgementOnlyExistsValidator();
	}
}
