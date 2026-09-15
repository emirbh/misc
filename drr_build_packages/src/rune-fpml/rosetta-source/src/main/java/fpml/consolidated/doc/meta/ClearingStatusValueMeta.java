package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ClearingStatusValue;
import fpml.consolidated.doc.validation.ClearingStatusValueTypeFormatValidator;
import fpml.consolidated.doc.validation.ClearingStatusValueValidator;
import fpml.consolidated.doc.validation.exists.ClearingStatusValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingStatusValue.class)
public class ClearingStatusValueMeta implements RosettaMetaData<ClearingStatusValue> {

	@Override
	public List<Validator<? super ClearingStatusValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingStatusValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingStatusValue> validator(ValidatorFactory factory) {
		return factory.<ClearingStatusValue>create(ClearingStatusValueValidator.class);
	}

	@Override
	public Validator<? super ClearingStatusValue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingStatusValue>create(ClearingStatusValueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingStatusValue> validator() {
		return new ClearingStatusValueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingStatusValue> typeFormatValidator() {
		return new ClearingStatusValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingStatusValue, Set<String>> onlyExistsValidator() {
		return new ClearingStatusValueOnlyExistsValidator();
	}
}
