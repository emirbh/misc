package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.LinkId;
import fpml.consolidated.doc.validation.LinkIdTypeFormatValidator;
import fpml.consolidated.doc.validation.LinkIdValidator;
import fpml.consolidated.doc.validation.exists.LinkIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LinkId.class)
public class LinkIdMeta implements RosettaMetaData<LinkId> {

	@Override
	public List<Validator<? super LinkId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LinkId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LinkId> validator(ValidatorFactory factory) {
		return factory.<LinkId>create(LinkIdValidator.class);
	}

	@Override
	public Validator<? super LinkId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LinkId>create(LinkIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LinkId> validator() {
		return new LinkIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LinkId> typeFormatValidator() {
		return new LinkIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LinkId, Set<String>> onlyExistsValidator() {
		return new LinkIdOnlyExistsValidator();
	}
}
