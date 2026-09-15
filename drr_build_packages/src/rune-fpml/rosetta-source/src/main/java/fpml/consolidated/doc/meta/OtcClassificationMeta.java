package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.OtcClassification;
import fpml.consolidated.doc.validation.OtcClassificationTypeFormatValidator;
import fpml.consolidated.doc.validation.OtcClassificationValidator;
import fpml.consolidated.doc.validation.exists.OtcClassificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OtcClassification.class)
public class OtcClassificationMeta implements RosettaMetaData<OtcClassification> {

	@Override
	public List<Validator<? super OtcClassification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtcClassification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OtcClassification> validator(ValidatorFactory factory) {
		return factory.<OtcClassification>create(OtcClassificationValidator.class);
	}

	@Override
	public Validator<? super OtcClassification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OtcClassification>create(OtcClassificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OtcClassification> validator() {
		return new OtcClassificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OtcClassification> typeFormatValidator() {
		return new OtcClassificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtcClassification, Set<String>> onlyExistsValidator() {
		return new OtcClassificationOnlyExistsValidator();
	}
}
