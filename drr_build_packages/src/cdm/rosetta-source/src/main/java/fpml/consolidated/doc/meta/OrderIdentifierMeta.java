package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.OrderIdentifier;
import fpml.consolidated.doc.validation.OrderIdentifierTypeFormatValidator;
import fpml.consolidated.doc.validation.OrderIdentifierValidator;
import fpml.consolidated.doc.validation.exists.OrderIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OrderIdentifier.class)
public class OrderIdentifierMeta implements RosettaMetaData<OrderIdentifier> {

	@Override
	public List<Validator<? super OrderIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrderIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrderIdentifier> validator(ValidatorFactory factory) {
		return factory.<OrderIdentifier>create(OrderIdentifierValidator.class);
	}

	@Override
	public Validator<? super OrderIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrderIdentifier>create(OrderIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrderIdentifier> validator() {
		return new OrderIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OrderIdentifier> typeFormatValidator() {
		return new OrderIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrderIdentifier, Set<String>> onlyExistsValidator() {
		return new OrderIdentifierOnlyExistsValidator();
	}
}
