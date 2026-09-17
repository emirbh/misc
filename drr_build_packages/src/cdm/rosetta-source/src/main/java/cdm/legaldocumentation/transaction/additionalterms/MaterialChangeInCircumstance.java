package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.additionalterms.meta.MaterialChangeInCircumstanceMeta;
import cdm.observable.asset.ValuationPostponement;
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
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * section "5.1.(d).(viii)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="MaterialChangeInCircumstance", builder=MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MaterialChangeInCircumstance", model="cdm", builder=MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilderImpl.class, version="6.23.0")
public interface MaterialChangeInCircumstance extends RosettaModelObject {

	MaterialChangeInCircumstanceMeta metaData = new MaterialChangeInCircumstanceMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getMaterialChangeInCircumstanceIsApplicable();
	EscrowArrangement getEscrowArrangement();
	ValuationPostponement getMaximumDaysOfDisruption();

	/*********************** Build Methods  ***********************/
	MaterialChangeInCircumstance build();
	
	MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder toBuilder();
	
	static MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder builder() {
		return new MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MaterialChangeInCircumstance> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MaterialChangeInCircumstance> getType() {
		return MaterialChangeInCircumstance.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("materialChangeInCircumstanceIsApplicable"), Boolean.class, getMaterialChangeInCircumstanceIsApplicable(), this);
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
		processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.class, getMaximumDaysOfDisruption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MaterialChangeInCircumstanceBuilder extends MaterialChangeInCircumstance, RosettaModelObjectBuilder {
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		ValuationPostponement.ValuationPostponementBuilder getOrCreateMaximumDaysOfDisruption();
		@Override
		ValuationPostponement.ValuationPostponementBuilder getMaximumDaysOfDisruption();
		MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder setMaterialChangeInCircumstanceIsApplicable(Boolean materialChangeInCircumstanceIsApplicable);
		MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);
		MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder setMaximumDaysOfDisruption(ValuationPostponement maximumDaysOfDisruption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("materialChangeInCircumstanceIsApplicable"), Boolean.class, getMaterialChangeInCircumstanceIsApplicable(), this);
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
			processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.ValuationPostponementBuilder.class, getMaximumDaysOfDisruption());
		}
		

		MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder prune();
	}

	/*********************** Immutable Implementation of MaterialChangeInCircumstance  ***********************/
	class MaterialChangeInCircumstanceImpl implements MaterialChangeInCircumstance {
		private final Boolean materialChangeInCircumstanceIsApplicable;
		private final EscrowArrangement escrowArrangement;
		private final ValuationPostponement maximumDaysOfDisruption;
		
		protected MaterialChangeInCircumstanceImpl(MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder builder) {
			this.materialChangeInCircumstanceIsApplicable = builder.getMaterialChangeInCircumstanceIsApplicable();
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
			this.maximumDaysOfDisruption = ofNullable(builder.getMaximumDaysOfDisruption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("materialChangeInCircumstanceIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("materialChangeInCircumstanceIsApplicable")
		public Boolean getMaterialChangeInCircumstanceIsApplicable() {
			return materialChangeInCircumstanceIsApplicable;
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		public ValuationPostponement getMaximumDaysOfDisruption() {
			return maximumDaysOfDisruption;
		}
		
		@Override
		public MaterialChangeInCircumstance build() {
			return this;
		}
		
		@Override
		public MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder toBuilder() {
			MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder builder) {
			ofNullable(getMaterialChangeInCircumstanceIsApplicable()).ifPresent(builder::setMaterialChangeInCircumstanceIsApplicable);
			ofNullable(getEscrowArrangement()).ifPresent(builder::setEscrowArrangement);
			ofNullable(getMaximumDaysOfDisruption()).ifPresent(builder::setMaximumDaysOfDisruption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MaterialChangeInCircumstance _that = getType().cast(o);
		
			if (!Objects.equals(materialChangeInCircumstanceIsApplicable, _that.getMaterialChangeInCircumstanceIsApplicable())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (materialChangeInCircumstanceIsApplicable != null ? materialChangeInCircumstanceIsApplicable.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaterialChangeInCircumstance {" +
				"materialChangeInCircumstanceIsApplicable=" + this.materialChangeInCircumstanceIsApplicable + ", " +
				"escrowArrangement=" + this.escrowArrangement + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption +
			'}';
		}
	}

	/*********************** Builder Implementation of MaterialChangeInCircumstance  ***********************/
	class MaterialChangeInCircumstanceBuilderImpl implements MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder {
	
		protected Boolean materialChangeInCircumstanceIsApplicable;
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		protected ValuationPostponement.ValuationPostponementBuilder maximumDaysOfDisruption;
		
		@Override
		@RosettaAttribute("materialChangeInCircumstanceIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("materialChangeInCircumstanceIsApplicable")
		public Boolean getMaterialChangeInCircumstanceIsApplicable() {
			return materialChangeInCircumstanceIsApplicable;
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		public EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement() {
			EscrowArrangement.EscrowArrangementBuilder result;
			if (escrowArrangement!=null) {
				result = escrowArrangement;
			}
			else {
				result = escrowArrangement = EscrowArrangement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		public ValuationPostponement.ValuationPostponementBuilder getMaximumDaysOfDisruption() {
			return maximumDaysOfDisruption;
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder getOrCreateMaximumDaysOfDisruption() {
			ValuationPostponement.ValuationPostponementBuilder result;
			if (maximumDaysOfDisruption!=null) {
				result = maximumDaysOfDisruption;
			}
			else {
				result = maximumDaysOfDisruption = ValuationPostponement.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("materialChangeInCircumstanceIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("materialChangeInCircumstanceIsApplicable")
		@Override
		public MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder setMaterialChangeInCircumstanceIsApplicable(Boolean _materialChangeInCircumstanceIsApplicable) {
			this.materialChangeInCircumstanceIsApplicable = _materialChangeInCircumstanceIsApplicable == null ? null : _materialChangeInCircumstanceIsApplicable;
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		@Override
		public MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder setMaximumDaysOfDisruption(ValuationPostponement _maximumDaysOfDisruption) {
			this.maximumDaysOfDisruption = _maximumDaysOfDisruption == null ? null : _maximumDaysOfDisruption.toBuilder();
			return this;
		}
		
		@Override
		public MaterialChangeInCircumstance build() {
			return new MaterialChangeInCircumstance.MaterialChangeInCircumstanceImpl(this);
		}
		
		@Override
		public MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder prune() {
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			if (maximumDaysOfDisruption!=null && !maximumDaysOfDisruption.prune().hasData()) maximumDaysOfDisruption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMaterialChangeInCircumstanceIsApplicable()!=null) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			if (getMaximumDaysOfDisruption()!=null && getMaximumDaysOfDisruption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder o = (MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder) other;
			
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			merger.mergeRosetta(getMaximumDaysOfDisruption(), o.getMaximumDaysOfDisruption(), this::setMaximumDaysOfDisruption);
			
			merger.mergeBasic(getMaterialChangeInCircumstanceIsApplicable(), o.getMaterialChangeInCircumstanceIsApplicable(), this::setMaterialChangeInCircumstanceIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MaterialChangeInCircumstance _that = getType().cast(o);
		
			if (!Objects.equals(materialChangeInCircumstanceIsApplicable, _that.getMaterialChangeInCircumstanceIsApplicable())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (materialChangeInCircumstanceIsApplicable != null ? materialChangeInCircumstanceIsApplicable.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaterialChangeInCircumstanceBuilder {" +
				"materialChangeInCircumstanceIsApplicable=" + this.materialChangeInCircumstanceIsApplicable + ", " +
				"escrowArrangement=" + this.escrowArrangement + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption +
			'}';
		}
	}
}
