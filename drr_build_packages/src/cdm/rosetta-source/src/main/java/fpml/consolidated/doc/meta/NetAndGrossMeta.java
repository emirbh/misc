package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.NetAndGross;
import fpml.consolidated.doc.validation.NetAndGrossTypeFormatValidator;
import fpml.consolidated.doc.validation.NetAndGrossValidator;
import fpml.consolidated.doc.validation.datarule.NetAndGrossChoice;
import fpml.consolidated.doc.validation.exists.NetAndGrossOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NetAndGross.class)
public class NetAndGrossMeta implements RosettaMetaData<NetAndGross> {

	@Override
	public List<Validator<? super NetAndGross>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<NetAndGross>create(NetAndGrossChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NetAndGross, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NetAndGross> validator(ValidatorFactory factory) {
		return factory.<NetAndGross>create(NetAndGrossValidator.class);
	}

	@Override
	public Validator<? super NetAndGross> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NetAndGross>create(NetAndGrossTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NetAndGross> validator() {
		return new NetAndGrossValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NetAndGross> typeFormatValidator() {
		return new NetAndGrossTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NetAndGross, Set<String>> onlyExistsValidator() {
		return new NetAndGrossOnlyExistsValidator();
	}
}
