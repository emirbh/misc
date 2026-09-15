package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.FxSettlementRateSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxSettlementRateSource", builder=FxSettlementRateSource.FxSettlementRateSourceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxSettlementRateSource", model="fpml", builder=FxSettlementRateSource.FxSettlementRateSourceBuilderImpl.class, version="2.1.1")
public interface FxSettlementRateSource extends RosettaModelObject {

	FxSettlementRateSourceMeta metaData = new FxSettlementRateSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that an officially defined rate settlement rate option will be the used for the fixing.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that an officially defined rate settlement rate option will be the used for the fixing.
	 *
	 */
	SettlementRateOption getSettlementRateOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that a non-standard rate source will be used for the fixing.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that a non-standard rate source will be used for the fixing.
	 *
	 */
	FxInformationSource getNonstandardSettlementRate();

	/*********************** Build Methods  ***********************/
	FxSettlementRateSource build();
	
	FxSettlementRateSource.FxSettlementRateSourceBuilder toBuilder();
	
	static FxSettlementRateSource.FxSettlementRateSourceBuilder builder() {
		return new FxSettlementRateSource.FxSettlementRateSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSettlementRateSource> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxSettlementRateSource> getType() {
		return FxSettlementRateSource.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementRateOption"), processor, SettlementRateOption.class, getSettlementRateOption());
		processRosetta(path.newSubPath("nonstandardSettlementRate"), processor, FxInformationSource.class, getNonstandardSettlementRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSettlementRateSourceBuilder extends FxSettlementRateSource, RosettaModelObjectBuilder {
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateSettlementRateOption();
		@Override
		SettlementRateOption.SettlementRateOptionBuilder getSettlementRateOption();
		FxInformationSource.FxInformationSourceBuilder getOrCreateNonstandardSettlementRate();
		@Override
		FxInformationSource.FxInformationSourceBuilder getNonstandardSettlementRate();
		FxSettlementRateSource.FxSettlementRateSourceBuilder setSettlementRateOption(SettlementRateOption settlementRateOption);
		FxSettlementRateSource.FxSettlementRateSourceBuilder setNonstandardSettlementRate(FxInformationSource nonstandardSettlementRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementRateOption"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getSettlementRateOption());
			processRosetta(path.newSubPath("nonstandardSettlementRate"), processor, FxInformationSource.FxInformationSourceBuilder.class, getNonstandardSettlementRate());
		}
		

		FxSettlementRateSource.FxSettlementRateSourceBuilder prune();
	}

	/*********************** Immutable Implementation of FxSettlementRateSource  ***********************/
	class FxSettlementRateSourceImpl implements FxSettlementRateSource {
		private final SettlementRateOption settlementRateOption;
		private final FxInformationSource nonstandardSettlementRate;
		
		protected FxSettlementRateSourceImpl(FxSettlementRateSource.FxSettlementRateSourceBuilder builder) {
			this.settlementRateOption = ofNullable(builder.getSettlementRateOption()).map(f->f.build()).orElse(null);
			this.nonstandardSettlementRate = ofNullable(builder.getNonstandardSettlementRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateOption")
		public SettlementRateOption getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		@RosettaAttribute("nonstandardSettlementRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonstandardSettlementRate")
		public FxInformationSource getNonstandardSettlementRate() {
			return nonstandardSettlementRate;
		}
		
		@Override
		public FxSettlementRateSource build() {
			return this;
		}
		
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder toBuilder() {
			FxSettlementRateSource.FxSettlementRateSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSettlementRateSource.FxSettlementRateSourceBuilder builder) {
			ofNullable(getSettlementRateOption()).ifPresent(builder::setSettlementRateOption);
			ofNullable(getNonstandardSettlementRate()).ifPresent(builder::setNonstandardSettlementRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSettlementRateSource _that = getType().cast(o);
		
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			if (!Objects.equals(nonstandardSettlementRate, _that.getNonstandardSettlementRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			_result = 31 * _result + (nonstandardSettlementRate != null ? nonstandardSettlementRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementRateSource {" +
				"settlementRateOption=" + this.settlementRateOption + ", " +
				"nonstandardSettlementRate=" + this.nonstandardSettlementRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxSettlementRateSource  ***********************/
	class FxSettlementRateSourceBuilderImpl implements FxSettlementRateSource.FxSettlementRateSourceBuilder {
	
		protected SettlementRateOption.SettlementRateOptionBuilder settlementRateOption;
		protected FxInformationSource.FxInformationSourceBuilder nonstandardSettlementRate;
		
		@Override
		@RosettaAttribute("settlementRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateOption")
		public SettlementRateOption.SettlementRateOptionBuilder getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreateSettlementRateOption() {
			SettlementRateOption.SettlementRateOptionBuilder result;
			if (settlementRateOption!=null) {
				result = settlementRateOption;
			}
			else {
				result = settlementRateOption = SettlementRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonstandardSettlementRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonstandardSettlementRate")
		public FxInformationSource.FxInformationSourceBuilder getNonstandardSettlementRate() {
			return nonstandardSettlementRate;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder getOrCreateNonstandardSettlementRate() {
			FxInformationSource.FxInformationSourceBuilder result;
			if (nonstandardSettlementRate!=null) {
				result = nonstandardSettlementRate;
			}
			else {
				result = nonstandardSettlementRate = FxInformationSource.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("settlementRateOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementRateOption")
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder setSettlementRateOption(SettlementRateOption _settlementRateOption) {
			this.settlementRateOption = _settlementRateOption == null ? null : _settlementRateOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonstandardSettlementRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonstandardSettlementRate")
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder setNonstandardSettlementRate(FxInformationSource _nonstandardSettlementRate) {
			this.nonstandardSettlementRate = _nonstandardSettlementRate == null ? null : _nonstandardSettlementRate.toBuilder();
			return this;
		}
		
		@Override
		public FxSettlementRateSource build() {
			return new FxSettlementRateSource.FxSettlementRateSourceImpl(this);
		}
		
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder prune() {
			if (settlementRateOption!=null && !settlementRateOption.prune().hasData()) settlementRateOption = null;
			if (nonstandardSettlementRate!=null && !nonstandardSettlementRate.prune().hasData()) nonstandardSettlementRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementRateOption()!=null && getSettlementRateOption().hasData()) return true;
			if (getNonstandardSettlementRate()!=null && getNonstandardSettlementRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementRateSource.FxSettlementRateSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxSettlementRateSource.FxSettlementRateSourceBuilder o = (FxSettlementRateSource.FxSettlementRateSourceBuilder) other;
			
			merger.mergeRosetta(getSettlementRateOption(), o.getSettlementRateOption(), this::setSettlementRateOption);
			merger.mergeRosetta(getNonstandardSettlementRate(), o.getNonstandardSettlementRate(), this::setNonstandardSettlementRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSettlementRateSource _that = getType().cast(o);
		
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			if (!Objects.equals(nonstandardSettlementRate, _that.getNonstandardSettlementRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			_result = 31 * _result + (nonstandardSettlementRate != null ? nonstandardSettlementRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementRateSourceBuilder {" +
				"settlementRateOption=" + this.settlementRateOption + ", " +
				"nonstandardSettlementRate=" + this.nonstandardSettlementRate +
			'}';
		}
	}
}
