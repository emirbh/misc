package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.ExecutionTermsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify execution location and language of execution to determine duty to be paid.
 * @version 6.23.0
 */
@RosettaDataType(value="ExecutionTerms", builder=ExecutionTerms.ExecutionTermsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ExecutionTerms", model="cdm", builder=ExecutionTerms.ExecutionTermsBuilderImpl.class, version="6.23.0")
public interface ExecutionTerms extends RosettaModelObject {

	ExecutionTermsMeta metaData = new ExecutionTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The bespoke execution language election.
	 */
	ExecutionLanguage getExecutionLanguage();
	/**
	 * The bespoke execution location election.
	 */
	ExecutionLocation getExecutionLocation();

	/*********************** Build Methods  ***********************/
	ExecutionTerms build();
	
	ExecutionTerms.ExecutionTermsBuilder toBuilder();
	
	static ExecutionTerms.ExecutionTermsBuilder builder() {
		return new ExecutionTerms.ExecutionTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExecutionTerms> getType() {
		return ExecutionTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("executionLanguage"), processor, ExecutionLanguage.class, getExecutionLanguage());
		processRosetta(path.newSubPath("executionLocation"), processor, ExecutionLocation.class, getExecutionLocation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionTermsBuilder extends ExecutionTerms, RosettaModelObjectBuilder {
		ExecutionLanguage.ExecutionLanguageBuilder getOrCreateExecutionLanguage();
		@Override
		ExecutionLanguage.ExecutionLanguageBuilder getExecutionLanguage();
		ExecutionLocation.ExecutionLocationBuilder getOrCreateExecutionLocation();
		@Override
		ExecutionLocation.ExecutionLocationBuilder getExecutionLocation();
		ExecutionTerms.ExecutionTermsBuilder setExecutionLanguage(ExecutionLanguage executionLanguage);
		ExecutionTerms.ExecutionTermsBuilder setExecutionLocation(ExecutionLocation executionLocation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("executionLanguage"), processor, ExecutionLanguage.ExecutionLanguageBuilder.class, getExecutionLanguage());
			processRosetta(path.newSubPath("executionLocation"), processor, ExecutionLocation.ExecutionLocationBuilder.class, getExecutionLocation());
		}
		

		ExecutionTerms.ExecutionTermsBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionTerms  ***********************/
	class ExecutionTermsImpl implements ExecutionTerms {
		private final ExecutionLanguage executionLanguage;
		private final ExecutionLocation executionLocation;
		
		protected ExecutionTermsImpl(ExecutionTerms.ExecutionTermsBuilder builder) {
			this.executionLanguage = ofNullable(builder.getExecutionLanguage()).map(f->f.build()).orElse(null);
			this.executionLocation = ofNullable(builder.getExecutionLocation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("executionLanguage")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionLanguage")
		public ExecutionLanguage getExecutionLanguage() {
			return executionLanguage;
		}
		
		@Override
		@RosettaAttribute("executionLocation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionLocation")
		public ExecutionLocation getExecutionLocation() {
			return executionLocation;
		}
		
		@Override
		public ExecutionTerms build() {
			return this;
		}
		
		@Override
		public ExecutionTerms.ExecutionTermsBuilder toBuilder() {
			ExecutionTerms.ExecutionTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionTerms.ExecutionTermsBuilder builder) {
			ofNullable(getExecutionLanguage()).ifPresent(builder::setExecutionLanguage);
			ofNullable(getExecutionLocation()).ifPresent(builder::setExecutionLocation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionTerms _that = getType().cast(o);
		
			if (!Objects.equals(executionLanguage, _that.getExecutionLanguage())) return false;
			if (!Objects.equals(executionLocation, _that.getExecutionLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executionLanguage != null ? executionLanguage.hashCode() : 0);
			_result = 31 * _result + (executionLocation != null ? executionLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionTerms {" +
				"executionLanguage=" + this.executionLanguage + ", " +
				"executionLocation=" + this.executionLocation +
			'}';
		}
	}

	/*********************** Builder Implementation of ExecutionTerms  ***********************/
	class ExecutionTermsBuilderImpl implements ExecutionTerms.ExecutionTermsBuilder {
	
		protected ExecutionLanguage.ExecutionLanguageBuilder executionLanguage;
		protected ExecutionLocation.ExecutionLocationBuilder executionLocation;
		
		@Override
		@RosettaAttribute("executionLanguage")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionLanguage")
		public ExecutionLanguage.ExecutionLanguageBuilder getExecutionLanguage() {
			return executionLanguage;
		}
		
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder getOrCreateExecutionLanguage() {
			ExecutionLanguage.ExecutionLanguageBuilder result;
			if (executionLanguage!=null) {
				result = executionLanguage;
			}
			else {
				result = executionLanguage = ExecutionLanguage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("executionLocation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionLocation")
		public ExecutionLocation.ExecutionLocationBuilder getExecutionLocation() {
			return executionLocation;
		}
		
		@Override
		public ExecutionLocation.ExecutionLocationBuilder getOrCreateExecutionLocation() {
			ExecutionLocation.ExecutionLocationBuilder result;
			if (executionLocation!=null) {
				result = executionLocation;
			}
			else {
				result = executionLocation = ExecutionLocation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("executionLanguage")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionLanguage")
		@Override
		public ExecutionTerms.ExecutionTermsBuilder setExecutionLanguage(ExecutionLanguage _executionLanguage) {
			this.executionLanguage = _executionLanguage == null ? null : _executionLanguage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("executionLocation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionLocation")
		@Override
		public ExecutionTerms.ExecutionTermsBuilder setExecutionLocation(ExecutionLocation _executionLocation) {
			this.executionLocation = _executionLocation == null ? null : _executionLocation.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionTerms build() {
			return new ExecutionTerms.ExecutionTermsImpl(this);
		}
		
		@Override
		public ExecutionTerms.ExecutionTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionTerms.ExecutionTermsBuilder prune() {
			if (executionLanguage!=null && !executionLanguage.prune().hasData()) executionLanguage = null;
			if (executionLocation!=null && !executionLocation.prune().hasData()) executionLocation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExecutionLanguage()!=null && getExecutionLanguage().hasData()) return true;
			if (getExecutionLocation()!=null && getExecutionLocation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionTerms.ExecutionTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionTerms.ExecutionTermsBuilder o = (ExecutionTerms.ExecutionTermsBuilder) other;
			
			merger.mergeRosetta(getExecutionLanguage(), o.getExecutionLanguage(), this::setExecutionLanguage);
			merger.mergeRosetta(getExecutionLocation(), o.getExecutionLocation(), this::setExecutionLocation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionTerms _that = getType().cast(o);
		
			if (!Objects.equals(executionLanguage, _that.getExecutionLanguage())) return false;
			if (!Objects.equals(executionLocation, _that.getExecutionLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executionLanguage != null ? executionLanguage.hashCode() : 0);
			_result = 31 * _result + (executionLocation != null ? executionLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionTermsBuilder {" +
				"executionLanguage=" + this.executionLanguage + ", " +
				"executionLocation=" + this.executionLocation +
			'}';
		}
	}
}
