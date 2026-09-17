package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.SensitivityMethodologyMeta;
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
 * A class to specify the methodology according to which sensitivities are computed.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(gg)(2)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="SensitivityMethodology", builder=SensitivityMethodology.SensitivityMethodologyBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SensitivityMethodology", model="cdm", builder=SensitivityMethodology.SensitivityMethodologyBuilderImpl.class, version="6.23.0")
public interface SensitivityMethodology extends RosettaModelObject {

	SensitivityMethodologyMeta metaData = new SensitivityMethodologyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The methodology according to which sensitivities will be computed, when specified through a normalized election.
	 */
	SensitivitiesEnum getSpecifiedMethodology();
	/**
	 * The methodology according to which sensitivities will be computed, when specified through a custom election.
	 */
	String getCustomMethodology();

	/*********************** Build Methods  ***********************/
	SensitivityMethodology build();
	
	SensitivityMethodology.SensitivityMethodologyBuilder toBuilder();
	
	static SensitivityMethodology.SensitivityMethodologyBuilder builder() {
		return new SensitivityMethodology.SensitivityMethodologyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivityMethodology> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SensitivityMethodology> getType() {
		return SensitivityMethodology.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("specifiedMethodology"), SensitivitiesEnum.class, getSpecifiedMethodology(), this);
		processor.processBasic(path.newSubPath("customMethodology"), String.class, getCustomMethodology(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivityMethodologyBuilder extends SensitivityMethodology, RosettaModelObjectBuilder {
		SensitivityMethodology.SensitivityMethodologyBuilder setSpecifiedMethodology(SensitivitiesEnum specifiedMethodology);
		SensitivityMethodology.SensitivityMethodologyBuilder setCustomMethodology(String customMethodology);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("specifiedMethodology"), SensitivitiesEnum.class, getSpecifiedMethodology(), this);
			processor.processBasic(path.newSubPath("customMethodology"), String.class, getCustomMethodology(), this);
		}
		

		SensitivityMethodology.SensitivityMethodologyBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivityMethodology  ***********************/
	class SensitivityMethodologyImpl implements SensitivityMethodology {
		private final SensitivitiesEnum specifiedMethodology;
		private final String customMethodology;
		
		protected SensitivityMethodologyImpl(SensitivityMethodology.SensitivityMethodologyBuilder builder) {
			this.specifiedMethodology = builder.getSpecifiedMethodology();
			this.customMethodology = builder.getCustomMethodology();
		}
		
		@Override
		@RosettaAttribute("specifiedMethodology")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specifiedMethodology")
		public SensitivitiesEnum getSpecifiedMethodology() {
			return specifiedMethodology;
		}
		
		@Override
		@RosettaAttribute("customMethodology")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customMethodology")
		public String getCustomMethodology() {
			return customMethodology;
		}
		
		@Override
		public SensitivityMethodology build() {
			return this;
		}
		
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder toBuilder() {
			SensitivityMethodology.SensitivityMethodologyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivityMethodology.SensitivityMethodologyBuilder builder) {
			ofNullable(getSpecifiedMethodology()).ifPresent(builder::setSpecifiedMethodology);
			ofNullable(getCustomMethodology()).ifPresent(builder::setCustomMethodology);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityMethodology _that = getType().cast(o);
		
			if (!Objects.equals(specifiedMethodology, _that.getSpecifiedMethodology())) return false;
			if (!Objects.equals(customMethodology, _that.getCustomMethodology())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specifiedMethodology != null ? specifiedMethodology.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customMethodology != null ? customMethodology.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityMethodology {" +
				"specifiedMethodology=" + this.specifiedMethodology + ", " +
				"customMethodology=" + this.customMethodology +
			'}';
		}
	}

	/*********************** Builder Implementation of SensitivityMethodology  ***********************/
	class SensitivityMethodologyBuilderImpl implements SensitivityMethodology.SensitivityMethodologyBuilder {
	
		protected SensitivitiesEnum specifiedMethodology;
		protected String customMethodology;
		
		@Override
		@RosettaAttribute("specifiedMethodology")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specifiedMethodology")
		public SensitivitiesEnum getSpecifiedMethodology() {
			return specifiedMethodology;
		}
		
		@Override
		@RosettaAttribute("customMethodology")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customMethodology")
		public String getCustomMethodology() {
			return customMethodology;
		}
		
		@RosettaAttribute("specifiedMethodology")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specifiedMethodology")
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder setSpecifiedMethodology(SensitivitiesEnum _specifiedMethodology) {
			this.specifiedMethodology = _specifiedMethodology == null ? null : _specifiedMethodology;
			return this;
		}
		
		@RosettaAttribute("customMethodology")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customMethodology")
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder setCustomMethodology(String _customMethodology) {
			this.customMethodology = _customMethodology == null ? null : _customMethodology;
			return this;
		}
		
		@Override
		public SensitivityMethodology build() {
			return new SensitivityMethodology.SensitivityMethodologyImpl(this);
		}
		
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpecifiedMethodology()!=null) return true;
			if (getCustomMethodology()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivityMethodology.SensitivityMethodologyBuilder o = (SensitivityMethodology.SensitivityMethodologyBuilder) other;
			
			
			merger.mergeBasic(getSpecifiedMethodology(), o.getSpecifiedMethodology(), this::setSpecifiedMethodology);
			merger.mergeBasic(getCustomMethodology(), o.getCustomMethodology(), this::setCustomMethodology);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityMethodology _that = getType().cast(o);
		
			if (!Objects.equals(specifiedMethodology, _that.getSpecifiedMethodology())) return false;
			if (!Objects.equals(customMethodology, _that.getCustomMethodology())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specifiedMethodology != null ? specifiedMethodology.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customMethodology != null ? customMethodology.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityMethodologyBuilder {" +
				"specifiedMethodology=" + this.specifiedMethodology + ", " +
				"customMethodology=" + this.customMethodology +
			'}';
		}
	}
}
