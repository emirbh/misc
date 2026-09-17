package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.additionalterms.meta.FxInconvertibilityOrNonTransferabilityMeta;
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
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * section "5.1.(d).(vii)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxInconvertibilityOrNonTransferability", builder=FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FxInconvertibilityOrNonTransferability", model="cdm", builder=FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilderImpl.class, version="6.23.0")
public interface FxInconvertibilityOrNonTransferability extends RosettaModelObject {

	FxInconvertibilityOrNonTransferabilityMeta metaData = new FxInconvertibilityOrNonTransferabilityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(iii)"
	 *
	 * Provision 
	 *
	 */
	GeneralInconvertibility getGeneralInconvertibility();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(iv)"
	 *
	 * Provision 
	 *
	 */
	GeneralNonTransferability getGeneralNonTransferability();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(xii)"
	 *
	 * Provision 
	 *
	 */
	SpecificInconvertibility getSpecificInconvertibility();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(xiii)"
	 *
	 * Provision 
	 *
	 */
	SpecificNonTransferability getSpecificNonTransferability();

	/*********************** Build Methods  ***********************/
	FxInconvertibilityOrNonTransferability build();
	
	FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder toBuilder();
	
	static FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder builder() {
		return new FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxInconvertibilityOrNonTransferability> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxInconvertibilityOrNonTransferability> getType() {
		return FxInconvertibilityOrNonTransferability.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("generalInconvertibility"), processor, GeneralInconvertibility.class, getGeneralInconvertibility());
		processRosetta(path.newSubPath("generalNonTransferability"), processor, GeneralNonTransferability.class, getGeneralNonTransferability());
		processRosetta(path.newSubPath("specificInconvertibility"), processor, SpecificInconvertibility.class, getSpecificInconvertibility());
		processRosetta(path.newSubPath("specificNonTransferability"), processor, SpecificNonTransferability.class, getSpecificNonTransferability());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxInconvertibilityOrNonTransferabilityBuilder extends FxInconvertibilityOrNonTransferability, RosettaModelObjectBuilder {
		GeneralInconvertibility.GeneralInconvertibilityBuilder getOrCreateGeneralInconvertibility();
		@Override
		GeneralInconvertibility.GeneralInconvertibilityBuilder getGeneralInconvertibility();
		GeneralNonTransferability.GeneralNonTransferabilityBuilder getOrCreateGeneralNonTransferability();
		@Override
		GeneralNonTransferability.GeneralNonTransferabilityBuilder getGeneralNonTransferability();
		SpecificInconvertibility.SpecificInconvertibilityBuilder getOrCreateSpecificInconvertibility();
		@Override
		SpecificInconvertibility.SpecificInconvertibilityBuilder getSpecificInconvertibility();
		SpecificNonTransferability.SpecificNonTransferabilityBuilder getOrCreateSpecificNonTransferability();
		@Override
		SpecificNonTransferability.SpecificNonTransferabilityBuilder getSpecificNonTransferability();
		FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder setGeneralInconvertibility(GeneralInconvertibility generalInconvertibility);
		FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder setGeneralNonTransferability(GeneralNonTransferability generalNonTransferability);
		FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder setSpecificInconvertibility(SpecificInconvertibility specificInconvertibility);
		FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder setSpecificNonTransferability(SpecificNonTransferability specificNonTransferability);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("generalInconvertibility"), processor, GeneralInconvertibility.GeneralInconvertibilityBuilder.class, getGeneralInconvertibility());
			processRosetta(path.newSubPath("generalNonTransferability"), processor, GeneralNonTransferability.GeneralNonTransferabilityBuilder.class, getGeneralNonTransferability());
			processRosetta(path.newSubPath("specificInconvertibility"), processor, SpecificInconvertibility.SpecificInconvertibilityBuilder.class, getSpecificInconvertibility());
			processRosetta(path.newSubPath("specificNonTransferability"), processor, SpecificNonTransferability.SpecificNonTransferabilityBuilder.class, getSpecificNonTransferability());
		}
		

		FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder prune();
	}

	/*********************** Immutable Implementation of FxInconvertibilityOrNonTransferability  ***********************/
	class FxInconvertibilityOrNonTransferabilityImpl implements FxInconvertibilityOrNonTransferability {
		private final GeneralInconvertibility generalInconvertibility;
		private final GeneralNonTransferability generalNonTransferability;
		private final SpecificInconvertibility specificInconvertibility;
		private final SpecificNonTransferability specificNonTransferability;
		
		protected FxInconvertibilityOrNonTransferabilityImpl(FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder builder) {
			this.generalInconvertibility = ofNullable(builder.getGeneralInconvertibility()).map(f->f.build()).orElse(null);
			this.generalNonTransferability = ofNullable(builder.getGeneralNonTransferability()).map(f->f.build()).orElse(null);
			this.specificInconvertibility = ofNullable(builder.getSpecificInconvertibility()).map(f->f.build()).orElse(null);
			this.specificNonTransferability = ofNullable(builder.getSpecificNonTransferability()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("generalInconvertibility")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generalInconvertibility")
		public GeneralInconvertibility getGeneralInconvertibility() {
			return generalInconvertibility;
		}
		
		@Override
		@RosettaAttribute("generalNonTransferability")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generalNonTransferability")
		public GeneralNonTransferability getGeneralNonTransferability() {
			return generalNonTransferability;
		}
		
		@Override
		@RosettaAttribute("specificInconvertibility")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificInconvertibility")
		public SpecificInconvertibility getSpecificInconvertibility() {
			return specificInconvertibility;
		}
		
		@Override
		@RosettaAttribute("specificNonTransferability")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificNonTransferability")
		public SpecificNonTransferability getSpecificNonTransferability() {
			return specificNonTransferability;
		}
		
		@Override
		public FxInconvertibilityOrNonTransferability build() {
			return this;
		}
		
		@Override
		public FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder toBuilder() {
			FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder builder) {
			ofNullable(getGeneralInconvertibility()).ifPresent(builder::setGeneralInconvertibility);
			ofNullable(getGeneralNonTransferability()).ifPresent(builder::setGeneralNonTransferability);
			ofNullable(getSpecificInconvertibility()).ifPresent(builder::setSpecificInconvertibility);
			ofNullable(getSpecificNonTransferability()).ifPresent(builder::setSpecificNonTransferability);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxInconvertibilityOrNonTransferability _that = getType().cast(o);
		
			if (!Objects.equals(generalInconvertibility, _that.getGeneralInconvertibility())) return false;
			if (!Objects.equals(generalNonTransferability, _that.getGeneralNonTransferability())) return false;
			if (!Objects.equals(specificInconvertibility, _that.getSpecificInconvertibility())) return false;
			if (!Objects.equals(specificNonTransferability, _that.getSpecificNonTransferability())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (generalInconvertibility != null ? generalInconvertibility.hashCode() : 0);
			_result = 31 * _result + (generalNonTransferability != null ? generalNonTransferability.hashCode() : 0);
			_result = 31 * _result + (specificInconvertibility != null ? specificInconvertibility.hashCode() : 0);
			_result = 31 * _result + (specificNonTransferability != null ? specificNonTransferability.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxInconvertibilityOrNonTransferability {" +
				"generalInconvertibility=" + this.generalInconvertibility + ", " +
				"generalNonTransferability=" + this.generalNonTransferability + ", " +
				"specificInconvertibility=" + this.specificInconvertibility + ", " +
				"specificNonTransferability=" + this.specificNonTransferability +
			'}';
		}
	}

	/*********************** Builder Implementation of FxInconvertibilityOrNonTransferability  ***********************/
	class FxInconvertibilityOrNonTransferabilityBuilderImpl implements FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder {
	
		protected GeneralInconvertibility.GeneralInconvertibilityBuilder generalInconvertibility;
		protected GeneralNonTransferability.GeneralNonTransferabilityBuilder generalNonTransferability;
		protected SpecificInconvertibility.SpecificInconvertibilityBuilder specificInconvertibility;
		protected SpecificNonTransferability.SpecificNonTransferabilityBuilder specificNonTransferability;
		
		@Override
		@RosettaAttribute("generalInconvertibility")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generalInconvertibility")
		public GeneralInconvertibility.GeneralInconvertibilityBuilder getGeneralInconvertibility() {
			return generalInconvertibility;
		}
		
		@Override
		public GeneralInconvertibility.GeneralInconvertibilityBuilder getOrCreateGeneralInconvertibility() {
			GeneralInconvertibility.GeneralInconvertibilityBuilder result;
			if (generalInconvertibility!=null) {
				result = generalInconvertibility;
			}
			else {
				result = generalInconvertibility = GeneralInconvertibility.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("generalNonTransferability")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generalNonTransferability")
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder getGeneralNonTransferability() {
			return generalNonTransferability;
		}
		
		@Override
		public GeneralNonTransferability.GeneralNonTransferabilityBuilder getOrCreateGeneralNonTransferability() {
			GeneralNonTransferability.GeneralNonTransferabilityBuilder result;
			if (generalNonTransferability!=null) {
				result = generalNonTransferability;
			}
			else {
				result = generalNonTransferability = GeneralNonTransferability.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("specificInconvertibility")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificInconvertibility")
		public SpecificInconvertibility.SpecificInconvertibilityBuilder getSpecificInconvertibility() {
			return specificInconvertibility;
		}
		
		@Override
		public SpecificInconvertibility.SpecificInconvertibilityBuilder getOrCreateSpecificInconvertibility() {
			SpecificInconvertibility.SpecificInconvertibilityBuilder result;
			if (specificInconvertibility!=null) {
				result = specificInconvertibility;
			}
			else {
				result = specificInconvertibility = SpecificInconvertibility.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("specificNonTransferability")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificNonTransferability")
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder getSpecificNonTransferability() {
			return specificNonTransferability;
		}
		
		@Override
		public SpecificNonTransferability.SpecificNonTransferabilityBuilder getOrCreateSpecificNonTransferability() {
			SpecificNonTransferability.SpecificNonTransferabilityBuilder result;
			if (specificNonTransferability!=null) {
				result = specificNonTransferability;
			}
			else {
				result = specificNonTransferability = SpecificNonTransferability.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("generalInconvertibility")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("generalInconvertibility")
		@Override
		public FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder setGeneralInconvertibility(GeneralInconvertibility _generalInconvertibility) {
			this.generalInconvertibility = _generalInconvertibility == null ? null : _generalInconvertibility.toBuilder();
			return this;
		}
		
		@RosettaAttribute("generalNonTransferability")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("generalNonTransferability")
		@Override
		public FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder setGeneralNonTransferability(GeneralNonTransferability _generalNonTransferability) {
			this.generalNonTransferability = _generalNonTransferability == null ? null : _generalNonTransferability.toBuilder();
			return this;
		}
		
		@RosettaAttribute("specificInconvertibility")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specificInconvertibility")
		@Override
		public FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder setSpecificInconvertibility(SpecificInconvertibility _specificInconvertibility) {
			this.specificInconvertibility = _specificInconvertibility == null ? null : _specificInconvertibility.toBuilder();
			return this;
		}
		
		@RosettaAttribute("specificNonTransferability")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specificNonTransferability")
		@Override
		public FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder setSpecificNonTransferability(SpecificNonTransferability _specificNonTransferability) {
			this.specificNonTransferability = _specificNonTransferability == null ? null : _specificNonTransferability.toBuilder();
			return this;
		}
		
		@Override
		public FxInconvertibilityOrNonTransferability build() {
			return new FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityImpl(this);
		}
		
		@Override
		public FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder prune() {
			if (generalInconvertibility!=null && !generalInconvertibility.prune().hasData()) generalInconvertibility = null;
			if (generalNonTransferability!=null && !generalNonTransferability.prune().hasData()) generalNonTransferability = null;
			if (specificInconvertibility!=null && !specificInconvertibility.prune().hasData()) specificInconvertibility = null;
			if (specificNonTransferability!=null && !specificNonTransferability.prune().hasData()) specificNonTransferability = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGeneralInconvertibility()!=null && getGeneralInconvertibility().hasData()) return true;
			if (getGeneralNonTransferability()!=null && getGeneralNonTransferability().hasData()) return true;
			if (getSpecificInconvertibility()!=null && getSpecificInconvertibility().hasData()) return true;
			if (getSpecificNonTransferability()!=null && getSpecificNonTransferability().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder o = (FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder) other;
			
			merger.mergeRosetta(getGeneralInconvertibility(), o.getGeneralInconvertibility(), this::setGeneralInconvertibility);
			merger.mergeRosetta(getGeneralNonTransferability(), o.getGeneralNonTransferability(), this::setGeneralNonTransferability);
			merger.mergeRosetta(getSpecificInconvertibility(), o.getSpecificInconvertibility(), this::setSpecificInconvertibility);
			merger.mergeRosetta(getSpecificNonTransferability(), o.getSpecificNonTransferability(), this::setSpecificNonTransferability);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxInconvertibilityOrNonTransferability _that = getType().cast(o);
		
			if (!Objects.equals(generalInconvertibility, _that.getGeneralInconvertibility())) return false;
			if (!Objects.equals(generalNonTransferability, _that.getGeneralNonTransferability())) return false;
			if (!Objects.equals(specificInconvertibility, _that.getSpecificInconvertibility())) return false;
			if (!Objects.equals(specificNonTransferability, _that.getSpecificNonTransferability())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (generalInconvertibility != null ? generalInconvertibility.hashCode() : 0);
			_result = 31 * _result + (generalNonTransferability != null ? generalNonTransferability.hashCode() : 0);
			_result = 31 * _result + (specificInconvertibility != null ? specificInconvertibility.hashCode() : 0);
			_result = 31 * _result + (specificNonTransferability != null ? specificNonTransferability.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxInconvertibilityOrNonTransferabilityBuilder {" +
				"generalInconvertibility=" + this.generalInconvertibility + ", " +
				"generalNonTransferability=" + this.generalNonTransferability + ", " +
				"specificInconvertibility=" + this.specificInconvertibility + ", " +
				"specificNonTransferability=" + this.specificNonTransferability +
			'}';
		}
	}
}
