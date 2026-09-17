package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.SensitivityMethodologiesMeta;
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
 * A class to specificy methodologies to compute sensitivities specific to the agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="SensitivityMethodologies", builder=SensitivityMethodologies.SensitivityMethodologiesBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SensitivityMethodologies", model="cdm", builder=SensitivityMethodologies.SensitivityMethodologiesBuilderImpl.class, version="6.23.0")
public interface SensitivityMethodologies extends RosettaModelObject {

	SensitivityMethodologiesMeta metaData = new SensitivityMethodologiesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The methodology to compute sensitivities to equity indices, funds and ETFs for the purpose of Initial Margin agreements.
	 */
	SensitivityMethodology getSensitivityToEquity();
	/**
	 * The methodology to compute sensitivities to commodity indices for the purpose of Initial Margin agreements.
	 */
	SensitivityMethodology getSensitivityToCommodity();

	/*********************** Build Methods  ***********************/
	SensitivityMethodologies build();
	
	SensitivityMethodologies.SensitivityMethodologiesBuilder toBuilder();
	
	static SensitivityMethodologies.SensitivityMethodologiesBuilder builder() {
		return new SensitivityMethodologies.SensitivityMethodologiesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivityMethodologies> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SensitivityMethodologies> getType() {
		return SensitivityMethodologies.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sensitivityToEquity"), processor, SensitivityMethodology.class, getSensitivityToEquity());
		processRosetta(path.newSubPath("sensitivityToCommodity"), processor, SensitivityMethodology.class, getSensitivityToCommodity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivityMethodologiesBuilder extends SensitivityMethodologies, RosettaModelObjectBuilder {
		SensitivityMethodology.SensitivityMethodologyBuilder getOrCreateSensitivityToEquity();
		@Override
		SensitivityMethodology.SensitivityMethodologyBuilder getSensitivityToEquity();
		SensitivityMethodology.SensitivityMethodologyBuilder getOrCreateSensitivityToCommodity();
		@Override
		SensitivityMethodology.SensitivityMethodologyBuilder getSensitivityToCommodity();
		SensitivityMethodologies.SensitivityMethodologiesBuilder setSensitivityToEquity(SensitivityMethodology sensitivityToEquity);
		SensitivityMethodologies.SensitivityMethodologiesBuilder setSensitivityToCommodity(SensitivityMethodology sensitivityToCommodity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sensitivityToEquity"), processor, SensitivityMethodology.SensitivityMethodologyBuilder.class, getSensitivityToEquity());
			processRosetta(path.newSubPath("sensitivityToCommodity"), processor, SensitivityMethodology.SensitivityMethodologyBuilder.class, getSensitivityToCommodity());
		}
		

		SensitivityMethodologies.SensitivityMethodologiesBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivityMethodologies  ***********************/
	class SensitivityMethodologiesImpl implements SensitivityMethodologies {
		private final SensitivityMethodology sensitivityToEquity;
		private final SensitivityMethodology sensitivityToCommodity;
		
		protected SensitivityMethodologiesImpl(SensitivityMethodologies.SensitivityMethodologiesBuilder builder) {
			this.sensitivityToEquity = ofNullable(builder.getSensitivityToEquity()).map(f->f.build()).orElse(null);
			this.sensitivityToCommodity = ofNullable(builder.getSensitivityToCommodity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("sensitivityToEquity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sensitivityToEquity")
		public SensitivityMethodology getSensitivityToEquity() {
			return sensitivityToEquity;
		}
		
		@Override
		@RosettaAttribute("sensitivityToCommodity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sensitivityToCommodity")
		public SensitivityMethodology getSensitivityToCommodity() {
			return sensitivityToCommodity;
		}
		
		@Override
		public SensitivityMethodologies build() {
			return this;
		}
		
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder toBuilder() {
			SensitivityMethodologies.SensitivityMethodologiesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivityMethodologies.SensitivityMethodologiesBuilder builder) {
			ofNullable(getSensitivityToEquity()).ifPresent(builder::setSensitivityToEquity);
			ofNullable(getSensitivityToCommodity()).ifPresent(builder::setSensitivityToCommodity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityMethodologies _that = getType().cast(o);
		
			if (!Objects.equals(sensitivityToEquity, _that.getSensitivityToEquity())) return false;
			if (!Objects.equals(sensitivityToCommodity, _that.getSensitivityToCommodity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sensitivityToEquity != null ? sensitivityToEquity.hashCode() : 0);
			_result = 31 * _result + (sensitivityToCommodity != null ? sensitivityToCommodity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityMethodologies {" +
				"sensitivityToEquity=" + this.sensitivityToEquity + ", " +
				"sensitivityToCommodity=" + this.sensitivityToCommodity +
			'}';
		}
	}

	/*********************** Builder Implementation of SensitivityMethodologies  ***********************/
	class SensitivityMethodologiesBuilderImpl implements SensitivityMethodologies.SensitivityMethodologiesBuilder {
	
		protected SensitivityMethodology.SensitivityMethodologyBuilder sensitivityToEquity;
		protected SensitivityMethodology.SensitivityMethodologyBuilder sensitivityToCommodity;
		
		@Override
		@RosettaAttribute("sensitivityToEquity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sensitivityToEquity")
		public SensitivityMethodology.SensitivityMethodologyBuilder getSensitivityToEquity() {
			return sensitivityToEquity;
		}
		
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder getOrCreateSensitivityToEquity() {
			SensitivityMethodology.SensitivityMethodologyBuilder result;
			if (sensitivityToEquity!=null) {
				result = sensitivityToEquity;
			}
			else {
				result = sensitivityToEquity = SensitivityMethodology.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sensitivityToCommodity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sensitivityToCommodity")
		public SensitivityMethodology.SensitivityMethodologyBuilder getSensitivityToCommodity() {
			return sensitivityToCommodity;
		}
		
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder getOrCreateSensitivityToCommodity() {
			SensitivityMethodology.SensitivityMethodologyBuilder result;
			if (sensitivityToCommodity!=null) {
				result = sensitivityToCommodity;
			}
			else {
				result = sensitivityToCommodity = SensitivityMethodology.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("sensitivityToEquity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sensitivityToEquity")
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder setSensitivityToEquity(SensitivityMethodology _sensitivityToEquity) {
			this.sensitivityToEquity = _sensitivityToEquity == null ? null : _sensitivityToEquity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sensitivityToCommodity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sensitivityToCommodity")
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder setSensitivityToCommodity(SensitivityMethodology _sensitivityToCommodity) {
			this.sensitivityToCommodity = _sensitivityToCommodity == null ? null : _sensitivityToCommodity.toBuilder();
			return this;
		}
		
		@Override
		public SensitivityMethodologies build() {
			return new SensitivityMethodologies.SensitivityMethodologiesImpl(this);
		}
		
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder prune() {
			if (sensitivityToEquity!=null && !sensitivityToEquity.prune().hasData()) sensitivityToEquity = null;
			if (sensitivityToCommodity!=null && !sensitivityToCommodity.prune().hasData()) sensitivityToCommodity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSensitivityToEquity()!=null && getSensitivityToEquity().hasData()) return true;
			if (getSensitivityToCommodity()!=null && getSensitivityToCommodity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivityMethodologies.SensitivityMethodologiesBuilder o = (SensitivityMethodologies.SensitivityMethodologiesBuilder) other;
			
			merger.mergeRosetta(getSensitivityToEquity(), o.getSensitivityToEquity(), this::setSensitivityToEquity);
			merger.mergeRosetta(getSensitivityToCommodity(), o.getSensitivityToCommodity(), this::setSensitivityToCommodity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityMethodologies _that = getType().cast(o);
		
			if (!Objects.equals(sensitivityToEquity, _that.getSensitivityToEquity())) return false;
			if (!Objects.equals(sensitivityToCommodity, _that.getSensitivityToCommodity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sensitivityToEquity != null ? sensitivityToEquity.hashCode() : 0);
			_result = 31 * _result + (sensitivityToCommodity != null ? sensitivityToCommodity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityMethodologiesBuilder {" +
				"sensitivityToEquity=" + this.sensitivityToEquity + ", " +
				"sensitivityToCommodity=" + this.sensitivityToCommodity +
			'}';
		}
	}
}
