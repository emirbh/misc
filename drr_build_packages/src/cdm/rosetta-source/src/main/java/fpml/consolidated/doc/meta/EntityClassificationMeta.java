package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.validation.EntityClassificationTypeFormatValidator;
import fpml.consolidated.doc.validation.EntityClassificationValidator;
import fpml.consolidated.doc.validation.exists.EntityClassificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EntityClassification.class)
public class EntityClassificationMeta implements RosettaMetaData<EntityClassification> {

	@Override
	public List<Validator<? super EntityClassification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EntityClassification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EntityClassification> validator(ValidatorFactory factory) {
		return factory.<EntityClassification>create(EntityClassificationValidator.class);
	}

	@Override
	public Validator<? super EntityClassification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EntityClassification>create(EntityClassificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EntityClassification> validator() {
		return new EntityClassificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EntityClassification> typeFormatValidator() {
		return new EntityClassificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EntityClassification, Set<String>> onlyExistsValidator() {
		return new EntityClassificationOnlyExistsValidator();
	}
}
