package fpml.consolidated.asset;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.asset.meta.MutualFundMeta;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Identifies the class of unit issued by a fund.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identifies the class of unit issued by a fund.
 *
 */
@RosettaDataType(value="MutualFund", builder=MutualFund.MutualFundBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MutualFund", model="fpml", builder=MutualFund.MutualFundBuilderImpl.class, version="2.1.1")
public interface MutualFund extends UnderlyingAsset {

	MutualFundMeta metaData = new MutualFundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Boolean indicator to specify whether the mutual fund is an open-ended mutual fund.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Boolean indicator to specify whether the mutual fund is an open-ended mutual fund.
	 *
	 */
	Boolean getOpenEndedFund();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fund manager that is in charge of the fund.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fund manager that is in charge of the fund.
	 *
	 */
	String getFundManager();

	/*********************** Build Methods  ***********************/
	MutualFund build();
	
	MutualFund.MutualFundBuilder toBuilder();
	
	static MutualFund.MutualFundBuilder builder() {
		return new MutualFund.MutualFundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MutualFund> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MutualFund> getType() {
		return MutualFund.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processor.processBasic(path.newSubPath("openEndedFund"), Boolean.class, getOpenEndedFund(), this);
		processor.processBasic(path.newSubPath("fundManager"), String.class, getFundManager(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MutualFundBuilder extends MutualFund, UnderlyingAsset.UnderlyingAssetBuilder {
		@Override
		MutualFund.MutualFundBuilder setId(String id);
		@Override
		MutualFund.MutualFundBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		MutualFund.MutualFundBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		MutualFund.MutualFundBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		MutualFund.MutualFundBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		MutualFund.MutualFundBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		MutualFund.MutualFundBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		MutualFund.MutualFundBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		MutualFund.MutualFundBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		MutualFund.MutualFundBuilder setDescription(String description);
		@Override
		MutualFund.MutualFundBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		MutualFund.MutualFundBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		MutualFund.MutualFundBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		MutualFund.MutualFundBuilder setDefinition(ProductReference definition);
		MutualFund.MutualFundBuilder setOpenEndedFund(Boolean openEndedFund);
		MutualFund.MutualFundBuilder setFundManager(String fundManager);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processor.processBasic(path.newSubPath("openEndedFund"), Boolean.class, getOpenEndedFund(), this);
			processor.processBasic(path.newSubPath("fundManager"), String.class, getFundManager(), this);
		}
		

		MutualFund.MutualFundBuilder prune();
	}

	/*********************** Immutable Implementation of MutualFund  ***********************/
	class MutualFundImpl extends UnderlyingAsset.UnderlyingAssetImpl implements MutualFund {
		private final Boolean openEndedFund;
		private final String fundManager;
		
		protected MutualFundImpl(MutualFund.MutualFundBuilder builder) {
			super(builder);
			this.openEndedFund = builder.getOpenEndedFund();
			this.fundManager = builder.getFundManager();
		}
		
		@Override
		@RosettaAttribute("openEndedFund")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("openEndedFund")
		public Boolean getOpenEndedFund() {
			return openEndedFund;
		}
		
		@Override
		@RosettaAttribute("fundManager")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fundManager")
		public String getFundManager() {
			return fundManager;
		}
		
		@Override
		public MutualFund build() {
			return this;
		}
		
		@Override
		public MutualFund.MutualFundBuilder toBuilder() {
			MutualFund.MutualFundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MutualFund.MutualFundBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOpenEndedFund()).ifPresent(builder::setOpenEndedFund);
			ofNullable(getFundManager()).ifPresent(builder::setFundManager);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MutualFund _that = getType().cast(o);
		
			if (!Objects.equals(openEndedFund, _that.getOpenEndedFund())) return false;
			if (!Objects.equals(fundManager, _that.getFundManager())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (openEndedFund != null ? openEndedFund.hashCode() : 0);
			_result = 31 * _result + (fundManager != null ? fundManager.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutualFund {" +
				"openEndedFund=" + this.openEndedFund + ", " +
				"fundManager=" + this.fundManager +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MutualFund  ***********************/
	class MutualFundBuilderImpl extends UnderlyingAsset.UnderlyingAssetBuilderImpl implements MutualFund.MutualFundBuilder {
	
		protected Boolean openEndedFund;
		protected String fundManager;
		
		@Override
		@RosettaAttribute("openEndedFund")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("openEndedFund")
		public Boolean getOpenEndedFund() {
			return openEndedFund;
		}
		
		@Override
		@RosettaAttribute("fundManager")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fundManager")
		public String getFundManager() {
			return fundManager;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public MutualFund.MutualFundBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public MutualFund.MutualFundBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public MutualFund.MutualFundBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public MutualFund.MutualFundBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public MutualFund.MutualFundBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public MutualFund.MutualFundBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public MutualFund.MutualFundBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public MutualFund.MutualFundBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public MutualFund.MutualFundBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public MutualFund.MutualFundBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public MutualFund.MutualFundBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public MutualFund.MutualFundBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public MutualFund.MutualFundBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public MutualFund.MutualFundBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("openEndedFund")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("openEndedFund")
		@Override
		public MutualFund.MutualFundBuilder setOpenEndedFund(Boolean _openEndedFund) {
			this.openEndedFund = _openEndedFund == null ? null : _openEndedFund;
			return this;
		}
		
		@RosettaAttribute("fundManager")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fundManager")
		@Override
		public MutualFund.MutualFundBuilder setFundManager(String _fundManager) {
			this.fundManager = _fundManager == null ? null : _fundManager;
			return this;
		}
		
		@Override
		public MutualFund build() {
			return new MutualFund.MutualFundImpl(this);
		}
		
		@Override
		public MutualFund.MutualFundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutualFund.MutualFundBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOpenEndedFund()!=null) return true;
			if (getFundManager()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutualFund.MutualFundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MutualFund.MutualFundBuilder o = (MutualFund.MutualFundBuilder) other;
			
			
			merger.mergeBasic(getOpenEndedFund(), o.getOpenEndedFund(), this::setOpenEndedFund);
			merger.mergeBasic(getFundManager(), o.getFundManager(), this::setFundManager);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MutualFund _that = getType().cast(o);
		
			if (!Objects.equals(openEndedFund, _that.getOpenEndedFund())) return false;
			if (!Objects.equals(fundManager, _that.getFundManager())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (openEndedFund != null ? openEndedFund.hashCode() : 0);
			_result = 31 * _result + (fundManager != null ? fundManager.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutualFundBuilder {" +
				"openEndedFund=" + this.openEndedFund + ", " +
				"fundManager=" + this.fundManager +
			'}' + " " + super.toString();
		}
	}
}
