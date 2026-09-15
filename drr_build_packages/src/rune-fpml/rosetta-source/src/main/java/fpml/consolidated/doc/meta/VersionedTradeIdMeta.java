package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.VersionedTradeId;
import fpml.consolidated.doc.validation.VersionedTradeIdTypeFormatValidator;
import fpml.consolidated.doc.validation.VersionedTradeIdValidator;
import fpml.consolidated.doc.validation.exists.VersionedTradeIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VersionedTradeId.class)
public class VersionedTradeIdMeta implements RosettaMetaData<VersionedTradeId> {

	@Override
	public List<Validator<? super VersionedTradeId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VersionedTradeId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VersionedTradeId> validator(ValidatorFactory factory) {
		return factory.<VersionedTradeId>create(VersionedTradeIdValidator.class);
	}

	@Override
	public Validator<? super VersionedTradeId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VersionedTradeId>create(VersionedTradeIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VersionedTradeId> validator() {
		return new VersionedTradeIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VersionedTradeId> typeFormatValidator() {
		return new VersionedTradeIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VersionedTradeId, Set<String>> onlyExistsValidator() {
		return new VersionedTradeIdOnlyExistsValidator();
	}
}
