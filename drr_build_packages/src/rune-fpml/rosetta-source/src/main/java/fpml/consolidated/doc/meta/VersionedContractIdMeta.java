package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.VersionedContractId;
import fpml.consolidated.doc.validation.VersionedContractIdTypeFormatValidator;
import fpml.consolidated.doc.validation.VersionedContractIdValidator;
import fpml.consolidated.doc.validation.exists.VersionedContractIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VersionedContractId.class)
public class VersionedContractIdMeta implements RosettaMetaData<VersionedContractId> {

	@Override
	public List<Validator<? super VersionedContractId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VersionedContractId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VersionedContractId> validator(ValidatorFactory factory) {
		return factory.<VersionedContractId>create(VersionedContractIdValidator.class);
	}

	@Override
	public Validator<? super VersionedContractId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VersionedContractId>create(VersionedContractIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VersionedContractId> validator() {
		return new VersionedContractIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VersionedContractId> typeFormatValidator() {
		return new VersionedContractIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VersionedContractId, Set<String>> onlyExistsValidator() {
		return new VersionedContractIdOnlyExistsValidator();
	}
}
