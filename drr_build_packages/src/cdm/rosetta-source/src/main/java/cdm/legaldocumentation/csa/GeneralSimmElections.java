package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.GeneralSimmElectionsMeta;
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
 * A class to specify the ISDA SIMM as the Method for all Covered Transactions with respect to all Regimes.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(ee)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="GeneralSimmElections", builder=GeneralSimmElections.GeneralSimmElectionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="GeneralSimmElections", model="cdm", builder=GeneralSimmElections.GeneralSimmElectionsBuilderImpl.class, version="6.23.0")
public interface GeneralSimmElections extends RosettaModelObject {

	GeneralSimmElectionsMeta metaData = new GeneralSimmElectionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The qualification of the ISDA SIMM version that is specified for all Covered Transactions.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(ee)(1)"
	 *
	 * Provision 
	 *
	 */
	SimmVersion getSimmVersion();
	/**
	 * The SIMM Calculation Currency, as specified for each of the parties to the CSA Initial Margin.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(ee)(3)"
	 *
	 * Provision 
	 *
	 */
	SimmCalculationCurrency getSimmCalculationCurrency();

	/*********************** Build Methods  ***********************/
	GeneralSimmElections build();
	
	GeneralSimmElections.GeneralSimmElectionsBuilder toBuilder();
	
	static GeneralSimmElections.GeneralSimmElectionsBuilder builder() {
		return new GeneralSimmElections.GeneralSimmElectionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GeneralSimmElections> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GeneralSimmElections> getType() {
		return GeneralSimmElections.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("simmVersion"), processor, SimmVersion.class, getSimmVersion());
		processRosetta(path.newSubPath("simmCalculationCurrency"), processor, SimmCalculationCurrency.class, getSimmCalculationCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GeneralSimmElectionsBuilder extends GeneralSimmElections, RosettaModelObjectBuilder {
		SimmVersion.SimmVersionBuilder getOrCreateSimmVersion();
		@Override
		SimmVersion.SimmVersionBuilder getSimmVersion();
		SimmCalculationCurrency.SimmCalculationCurrencyBuilder getOrCreateSimmCalculationCurrency();
		@Override
		SimmCalculationCurrency.SimmCalculationCurrencyBuilder getSimmCalculationCurrency();
		GeneralSimmElections.GeneralSimmElectionsBuilder setSimmVersion(SimmVersion simmVersion);
		GeneralSimmElections.GeneralSimmElectionsBuilder setSimmCalculationCurrency(SimmCalculationCurrency simmCalculationCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("simmVersion"), processor, SimmVersion.SimmVersionBuilder.class, getSimmVersion());
			processRosetta(path.newSubPath("simmCalculationCurrency"), processor, SimmCalculationCurrency.SimmCalculationCurrencyBuilder.class, getSimmCalculationCurrency());
		}
		

		GeneralSimmElections.GeneralSimmElectionsBuilder prune();
	}

	/*********************** Immutable Implementation of GeneralSimmElections  ***********************/
	class GeneralSimmElectionsImpl implements GeneralSimmElections {
		private final SimmVersion simmVersion;
		private final SimmCalculationCurrency simmCalculationCurrency;
		
		protected GeneralSimmElectionsImpl(GeneralSimmElections.GeneralSimmElectionsBuilder builder) {
			this.simmVersion = ofNullable(builder.getSimmVersion()).map(f->f.build()).orElse(null);
			this.simmCalculationCurrency = ofNullable(builder.getSimmCalculationCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("simmVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("simmVersion")
		public SimmVersion getSimmVersion() {
			return simmVersion;
		}
		
		@Override
		@RosettaAttribute("simmCalculationCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("simmCalculationCurrency")
		public SimmCalculationCurrency getSimmCalculationCurrency() {
			return simmCalculationCurrency;
		}
		
		@Override
		public GeneralSimmElections build() {
			return this;
		}
		
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder toBuilder() {
			GeneralSimmElections.GeneralSimmElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GeneralSimmElections.GeneralSimmElectionsBuilder builder) {
			ofNullable(getSimmVersion()).ifPresent(builder::setSimmVersion);
			ofNullable(getSimmCalculationCurrency()).ifPresent(builder::setSimmCalculationCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralSimmElections _that = getType().cast(o);
		
			if (!Objects.equals(simmVersion, _that.getSimmVersion())) return false;
			if (!Objects.equals(simmCalculationCurrency, _that.getSimmCalculationCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (simmVersion != null ? simmVersion.hashCode() : 0);
			_result = 31 * _result + (simmCalculationCurrency != null ? simmCalculationCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralSimmElections {" +
				"simmVersion=" + this.simmVersion + ", " +
				"simmCalculationCurrency=" + this.simmCalculationCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of GeneralSimmElections  ***********************/
	class GeneralSimmElectionsBuilderImpl implements GeneralSimmElections.GeneralSimmElectionsBuilder {
	
		protected SimmVersion.SimmVersionBuilder simmVersion;
		protected SimmCalculationCurrency.SimmCalculationCurrencyBuilder simmCalculationCurrency;
		
		@Override
		@RosettaAttribute("simmVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("simmVersion")
		public SimmVersion.SimmVersionBuilder getSimmVersion() {
			return simmVersion;
		}
		
		@Override
		public SimmVersion.SimmVersionBuilder getOrCreateSimmVersion() {
			SimmVersion.SimmVersionBuilder result;
			if (simmVersion!=null) {
				result = simmVersion;
			}
			else {
				result = simmVersion = SimmVersion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("simmCalculationCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("simmCalculationCurrency")
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder getSimmCalculationCurrency() {
			return simmCalculationCurrency;
		}
		
		@Override
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder getOrCreateSimmCalculationCurrency() {
			SimmCalculationCurrency.SimmCalculationCurrencyBuilder result;
			if (simmCalculationCurrency!=null) {
				result = simmCalculationCurrency;
			}
			else {
				result = simmCalculationCurrency = SimmCalculationCurrency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("simmVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("simmVersion")
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder setSimmVersion(SimmVersion _simmVersion) {
			this.simmVersion = _simmVersion == null ? null : _simmVersion.toBuilder();
			return this;
		}
		
		@RosettaAttribute("simmCalculationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("simmCalculationCurrency")
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder setSimmCalculationCurrency(SimmCalculationCurrency _simmCalculationCurrency) {
			this.simmCalculationCurrency = _simmCalculationCurrency == null ? null : _simmCalculationCurrency.toBuilder();
			return this;
		}
		
		@Override
		public GeneralSimmElections build() {
			return new GeneralSimmElections.GeneralSimmElectionsImpl(this);
		}
		
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder prune() {
			if (simmVersion!=null && !simmVersion.prune().hasData()) simmVersion = null;
			if (simmCalculationCurrency!=null && !simmCalculationCurrency.prune().hasData()) simmCalculationCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSimmVersion()!=null && getSimmVersion().hasData()) return true;
			if (getSimmCalculationCurrency()!=null && getSimmCalculationCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GeneralSimmElections.GeneralSimmElectionsBuilder o = (GeneralSimmElections.GeneralSimmElectionsBuilder) other;
			
			merger.mergeRosetta(getSimmVersion(), o.getSimmVersion(), this::setSimmVersion);
			merger.mergeRosetta(getSimmCalculationCurrency(), o.getSimmCalculationCurrency(), this::setSimmCalculationCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralSimmElections _that = getType().cast(o);
		
			if (!Objects.equals(simmVersion, _that.getSimmVersion())) return false;
			if (!Objects.equals(simmCalculationCurrency, _that.getSimmCalculationCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (simmVersion != null ? simmVersion.hashCode() : 0);
			_result = 31 * _result + (simmCalculationCurrency != null ? simmCalculationCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralSimmElectionsBuilder {" +
				"simmVersion=" + this.simmVersion + ", " +
				"simmCalculationCurrency=" + this.simmCalculationCurrency +
			'}';
		}
	}
}
