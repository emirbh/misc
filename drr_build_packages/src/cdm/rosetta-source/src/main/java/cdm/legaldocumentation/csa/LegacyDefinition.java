package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.LegacyDefinitionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
 * Bespoke language removing the pre-print requirement to transfer legal title of securities collateral through written instructions to the relevant depository institution or other securities intermediaries solely for the purposes of the 1994 New York Law Credit Support Annex.
 * @version 6.23.0
 */
@RosettaDataType(value="LegacyDefinition", builder=LegacyDefinition.LegacyDefinitionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegacyDefinition", model="cdm", builder=LegacyDefinition.LegacyDefinitionBuilderImpl.class, version="6.23.0")
public interface LegacyDefinition extends RosettaModelObject {

	LegacyDefinitionMeta metaData = new LegacyDefinitionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A boolean flag to represent bespoke amendment to the pre-print definition of Transfer.
	 */
	Boolean getIsApplicable();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	LegacyDefinition build();
	
	LegacyDefinition.LegacyDefinitionBuilder toBuilder();
	
	static LegacyDefinition.LegacyDefinitionBuilder builder() {
		return new LegacyDefinition.LegacyDefinitionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyDefinition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyDefinition> getType() {
		return LegacyDefinition.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyDefinitionBuilder extends LegacyDefinition, RosettaModelObjectBuilder {
		LegacyDefinition.LegacyDefinitionBuilder setIsApplicable(Boolean isApplicable);
		LegacyDefinition.LegacyDefinitionBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		LegacyDefinition.LegacyDefinitionBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyDefinition  ***********************/
	class LegacyDefinitionImpl implements LegacyDefinition {
		private final Boolean isApplicable;
		private final String additionalLanguage;
		
		protected LegacyDefinitionImpl(LegacyDefinition.LegacyDefinitionBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public LegacyDefinition build() {
			return this;
		}
		
		@Override
		public LegacyDefinition.LegacyDefinitionBuilder toBuilder() {
			LegacyDefinition.LegacyDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyDefinition.LegacyDefinitionBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyDefinition _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyDefinition {" +
				"isApplicable=" + this.isApplicable + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyDefinition  ***********************/
	class LegacyDefinitionBuilderImpl implements LegacyDefinition.LegacyDefinitionBuilder {
	
		protected Boolean isApplicable;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isApplicable")
		@Override
		public LegacyDefinition.LegacyDefinitionBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public LegacyDefinition.LegacyDefinitionBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public LegacyDefinition build() {
			return new LegacyDefinition.LegacyDefinitionImpl(this);
		}
		
		@Override
		public LegacyDefinition.LegacyDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyDefinition.LegacyDefinitionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyDefinition.LegacyDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyDefinition.LegacyDefinitionBuilder o = (LegacyDefinition.LegacyDefinitionBuilder) other;
			
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyDefinition _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyDefinitionBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
