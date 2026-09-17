package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.ExecutionLanguageMeta;
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
 * A class to specify execution language terms of a Security Agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="ExecutionLanguage", builder=ExecutionLanguage.ExecutionLanguageBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ExecutionLanguage", model="cdm", builder=ExecutionLanguage.ExecutionLanguageBuilderImpl.class, version="6.23.0")
public interface ExecutionLanguage extends RosettaModelObject {

	ExecutionLanguageMeta metaData = new ExecutionLanguageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A boolean attribute to determine if standard language is applicable or not.
	 */
	Boolean getStandardLanguage();
	/**
	 * The number of original documents.
	 */
	String getNumberOfOriginals();
	/**
	 * Bespoke execution language to be included when specified.
	 */
	String getOtherLanguage();

	/*********************** Build Methods  ***********************/
	ExecutionLanguage build();
	
	ExecutionLanguage.ExecutionLanguageBuilder toBuilder();
	
	static ExecutionLanguage.ExecutionLanguageBuilder builder() {
		return new ExecutionLanguage.ExecutionLanguageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionLanguage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExecutionLanguage> getType() {
		return ExecutionLanguage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardLanguage"), Boolean.class, getStandardLanguage(), this);
		processor.processBasic(path.newSubPath("numberOfOriginals"), String.class, getNumberOfOriginals(), this);
		processor.processBasic(path.newSubPath("otherLanguage"), String.class, getOtherLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionLanguageBuilder extends ExecutionLanguage, RosettaModelObjectBuilder {
		ExecutionLanguage.ExecutionLanguageBuilder setStandardLanguage(Boolean standardLanguage);
		ExecutionLanguage.ExecutionLanguageBuilder setNumberOfOriginals(String numberOfOriginals);
		ExecutionLanguage.ExecutionLanguageBuilder setOtherLanguage(String otherLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardLanguage"), Boolean.class, getStandardLanguage(), this);
			processor.processBasic(path.newSubPath("numberOfOriginals"), String.class, getNumberOfOriginals(), this);
			processor.processBasic(path.newSubPath("otherLanguage"), String.class, getOtherLanguage(), this);
		}
		

		ExecutionLanguage.ExecutionLanguageBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionLanguage  ***********************/
	class ExecutionLanguageImpl implements ExecutionLanguage {
		private final Boolean standardLanguage;
		private final String numberOfOriginals;
		private final String otherLanguage;
		
		protected ExecutionLanguageImpl(ExecutionLanguage.ExecutionLanguageBuilder builder) {
			this.standardLanguage = builder.getStandardLanguage();
			this.numberOfOriginals = builder.getNumberOfOriginals();
			this.otherLanguage = builder.getOtherLanguage();
		}
		
		@Override
		@RosettaAttribute("standardLanguage")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("standardLanguage")
		public Boolean getStandardLanguage() {
			return standardLanguage;
		}
		
		@Override
		@RosettaAttribute("numberOfOriginals")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOriginals")
		public String getNumberOfOriginals() {
			return numberOfOriginals;
		}
		
		@Override
		@RosettaAttribute("otherLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherLanguage")
		public String getOtherLanguage() {
			return otherLanguage;
		}
		
		@Override
		public ExecutionLanguage build() {
			return this;
		}
		
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder toBuilder() {
			ExecutionLanguage.ExecutionLanguageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionLanguage.ExecutionLanguageBuilder builder) {
			ofNullable(getStandardLanguage()).ifPresent(builder::setStandardLanguage);
			ofNullable(getNumberOfOriginals()).ifPresent(builder::setNumberOfOriginals);
			ofNullable(getOtherLanguage()).ifPresent(builder::setOtherLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionLanguage _that = getType().cast(o);
		
			if (!Objects.equals(standardLanguage, _that.getStandardLanguage())) return false;
			if (!Objects.equals(numberOfOriginals, _that.getNumberOfOriginals())) return false;
			if (!Objects.equals(otherLanguage, _that.getOtherLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardLanguage != null ? standardLanguage.hashCode() : 0);
			_result = 31 * _result + (numberOfOriginals != null ? numberOfOriginals.hashCode() : 0);
			_result = 31 * _result + (otherLanguage != null ? otherLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionLanguage {" +
				"standardLanguage=" + this.standardLanguage + ", " +
				"numberOfOriginals=" + this.numberOfOriginals + ", " +
				"otherLanguage=" + this.otherLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of ExecutionLanguage  ***********************/
	class ExecutionLanguageBuilderImpl implements ExecutionLanguage.ExecutionLanguageBuilder {
	
		protected Boolean standardLanguage;
		protected String numberOfOriginals;
		protected String otherLanguage;
		
		@Override
		@RosettaAttribute("standardLanguage")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("standardLanguage")
		public Boolean getStandardLanguage() {
			return standardLanguage;
		}
		
		@Override
		@RosettaAttribute("numberOfOriginals")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOriginals")
		public String getNumberOfOriginals() {
			return numberOfOriginals;
		}
		
		@Override
		@RosettaAttribute("otherLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherLanguage")
		public String getOtherLanguage() {
			return otherLanguage;
		}
		
		@RosettaAttribute("standardLanguage")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("standardLanguage")
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder setStandardLanguage(Boolean _standardLanguage) {
			this.standardLanguage = _standardLanguage == null ? null : _standardLanguage;
			return this;
		}
		
		@RosettaAttribute("numberOfOriginals")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfOriginals")
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder setNumberOfOriginals(String _numberOfOriginals) {
			this.numberOfOriginals = _numberOfOriginals == null ? null : _numberOfOriginals;
			return this;
		}
		
		@RosettaAttribute("otherLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherLanguage")
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder setOtherLanguage(String _otherLanguage) {
			this.otherLanguage = _otherLanguage == null ? null : _otherLanguage;
			return this;
		}
		
		@Override
		public ExecutionLanguage build() {
			return new ExecutionLanguage.ExecutionLanguageImpl(this);
		}
		
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardLanguage()!=null) return true;
			if (getNumberOfOriginals()!=null) return true;
			if (getOtherLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionLanguage.ExecutionLanguageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionLanguage.ExecutionLanguageBuilder o = (ExecutionLanguage.ExecutionLanguageBuilder) other;
			
			
			merger.mergeBasic(getStandardLanguage(), o.getStandardLanguage(), this::setStandardLanguage);
			merger.mergeBasic(getNumberOfOriginals(), o.getNumberOfOriginals(), this::setNumberOfOriginals);
			merger.mergeBasic(getOtherLanguage(), o.getOtherLanguage(), this::setOtherLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionLanguage _that = getType().cast(o);
		
			if (!Objects.equals(standardLanguage, _that.getStandardLanguage())) return false;
			if (!Objects.equals(numberOfOriginals, _that.getNumberOfOriginals())) return false;
			if (!Objects.equals(otherLanguage, _that.getOtherLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardLanguage != null ? standardLanguage.hashCode() : 0);
			_result = 31 * _result + (numberOfOriginals != null ? numberOfOriginals.hashCode() : 0);
			_result = 31 * _result + (otherLanguage != null ? otherLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionLanguageBuilder {" +
				"standardLanguage=" + this.standardLanguage + ", " +
				"numberOfOriginals=" + this.numberOfOriginals + ", " +
				"otherLanguage=" + this.otherLanguage +
			'}';
		}
	}
}
