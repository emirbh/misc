package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.OrderId;
import fpml.consolidated.doc.validation.OrderIdTypeFormatValidator;
import fpml.consolidated.doc.validation.OrderIdValidator;
import fpml.consolidated.doc.validation.exists.OrderIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OrderId.class)
public class OrderIdMeta implements RosettaMetaData<OrderId> {

	@Override
	public List<Validator<? super OrderId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrderId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrderId> validator(ValidatorFactory factory) {
		return factory.<OrderId>create(OrderIdValidator.class);
	}

	@Override
	public Validator<? super OrderId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrderId>create(OrderIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrderId> validator() {
		return new OrderIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OrderId> typeFormatValidator() {
		return new OrderIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrderId, Set<String>> onlyExistsValidator() {
		return new OrderIdOnlyExistsValidator();
	}
}
