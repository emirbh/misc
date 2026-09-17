package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.CallingPartyEnum;
import fpml.consolidated.fpmlenum.ExtensionStyleEnum;
import fpml.consolidated.fpmlenum.RepoDurationEnum;
import fpml.consolidated.repo.AdjustableOffset;
import fpml.consolidated.repo.Repo;
import fpml.consolidated.shared.AdjustableDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RepoChoice1")
@ImplementedBy(RepoChoice1.Default.class)
public interface RepoChoice1 extends Validator<Repo> {
	
	String NAME = "RepoChoice1";
	String DEFINITION = "duration exists or callingParty exists and extensionStyle is absent and extensionPeriod is absent and earliestCallDate is absent";
	
	class Default implements RepoChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Repo repo) {
			ComparisonResult result = executeDataRule(repo);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Repo", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Repo", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Repo repo) {
			try {
				return exists(MapperS.of(repo).<RepoDurationEnum>map("getDuration", _repo -> _repo.getDuration())).orNullSafe(exists(MapperS.of(repo).<CallingPartyEnum>map("getCallingParty", _repo -> _repo.getCallingParty())).andNullSafe(notExists(MapperS.of(repo).<ExtensionStyleEnum>map("getExtensionStyle", _repo -> _repo.getExtensionStyle()))).andNullSafe(notExists(MapperS.of(repo).<AdjustableOffset>map("getExtensionPeriod", _repo -> _repo.getExtensionPeriod()))).andNullSafe(notExists(MapperS.of(repo).<AdjustableDate>map("getEarliestCallDate", _repo -> _repo.getEarliestCallDate()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RepoChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Repo repo) {
			return Collections.emptyList();
		}
	}
}
