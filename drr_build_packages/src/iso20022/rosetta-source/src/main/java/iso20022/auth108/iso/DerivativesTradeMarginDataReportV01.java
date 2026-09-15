package iso20022.auth108.iso;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import iso20022.auth108.iso.meta.DerivativesTradeMarginDataReportV01Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The DerivativesTradeMarginDataReport message is sent by the report submitting entity to the trade repository (TR) to report the margins exchanged in relation to the derivative transactions or sent by the trade repository (TR) to the authority or made available by the trade repository (TR) to the report submitting entity and the reporting counterparty as well as the entity responsible for reporting, if applicable.
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativesTradeMarginDataReportV01", builder=DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DerivativesTradeMarginDataReportV01", model="iso20022", builder=DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01BuilderImpl.class, version="${project.version}")
public interface DerivativesTradeMarginDataReportV01 extends RosettaModelObject {

	DerivativesTradeMarginDataReportV01Meta metaData = new DerivativesTradeMarginDataReportV01Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Header information related to metadata of report message.
	 */
	TradeReportHeader4 getRptHdr();
	/**
	 * Set of data concerning the reporting trade.
	 */
	TradeData55Choice getTradData();
	/**
	 * Additional information that can not be captured in the structured fields and/or any other specific block.
	 */
	List<? extends SupplementaryData1> getSplmtryData();

	/*********************** Build Methods  ***********************/
	DerivativesTradeMarginDataReportV01 build();
	
	DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder toBuilder();
	
	static DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder builder() {
		return new DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativesTradeMarginDataReportV01> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativesTradeMarginDataReportV01> getType() {
		return DerivativesTradeMarginDataReportV01.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rptHdr"), processor, TradeReportHeader4.class, getRptHdr());
		processRosetta(path.newSubPath("tradData"), processor, TradeData55Choice.class, getTradData());
		processRosetta(path.newSubPath("splmtryData"), processor, SupplementaryData1.class, getSplmtryData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativesTradeMarginDataReportV01Builder extends DerivativesTradeMarginDataReportV01, RosettaModelObjectBuilder {
		TradeReportHeader4.TradeReportHeader4Builder getOrCreateRptHdr();
		@Override
		TradeReportHeader4.TradeReportHeader4Builder getRptHdr();
		TradeData55Choice.TradeData55ChoiceBuilder getOrCreateTradData();
		@Override
		TradeData55Choice.TradeData55ChoiceBuilder getTradData();
		SupplementaryData1.SupplementaryData1Builder getOrCreateSplmtryData(int index);
		@Override
		List<? extends SupplementaryData1.SupplementaryData1Builder> getSplmtryData();
		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder setRptHdr(TradeReportHeader4 rptHdr);
		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder setTradData(TradeData55Choice tradData);
		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder addSplmtryData(SupplementaryData1 splmtryData);
		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder addSplmtryData(SupplementaryData1 splmtryData, int idx);
		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder addSplmtryData(List<? extends SupplementaryData1> splmtryData);
		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder setSplmtryData(List<? extends SupplementaryData1> splmtryData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rptHdr"), processor, TradeReportHeader4.TradeReportHeader4Builder.class, getRptHdr());
			processRosetta(path.newSubPath("tradData"), processor, TradeData55Choice.TradeData55ChoiceBuilder.class, getTradData());
			processRosetta(path.newSubPath("splmtryData"), processor, SupplementaryData1.SupplementaryData1Builder.class, getSplmtryData());
		}
		

		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder prune();
	}

	/*********************** Immutable Implementation of DerivativesTradeMarginDataReportV01  ***********************/
	class DerivativesTradeMarginDataReportV01Impl implements DerivativesTradeMarginDataReportV01 {
		private final TradeReportHeader4 rptHdr;
		private final TradeData55Choice tradData;
		private final List<? extends SupplementaryData1> splmtryData;
		
		protected DerivativesTradeMarginDataReportV01Impl(DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder builder) {
			this.rptHdr = ofNullable(builder.getRptHdr()).map(f->f.build()).orElse(null);
			this.tradData = ofNullable(builder.getTradData()).map(f->f.build()).orElse(null);
			this.splmtryData = ofNullable(builder.getSplmtryData()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rptHdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptHdr")
		public TradeReportHeader4 getRptHdr() {
			return rptHdr;
		}
		
		@Override
		@RosettaAttribute("tradData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradData")
		public TradeData55Choice getTradData() {
			return tradData;
		}
		
		@Override
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("splmtryData")
		public List<? extends SupplementaryData1> getSplmtryData() {
			return splmtryData;
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01 build() {
			return this;
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder toBuilder() {
			DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder builder) {
			ofNullable(getRptHdr()).ifPresent(builder::setRptHdr);
			ofNullable(getTradData()).ifPresent(builder::setTradData);
			ofNullable(getSplmtryData()).ifPresent(builder::setSplmtryData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativesTradeMarginDataReportV01 _that = getType().cast(o);
		
			if (!Objects.equals(rptHdr, _that.getRptHdr())) return false;
			if (!Objects.equals(tradData, _that.getTradData())) return false;
			if (!ListEquals.listEquals(splmtryData, _that.getSplmtryData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptHdr != null ? rptHdr.hashCode() : 0);
			_result = 31 * _result + (tradData != null ? tradData.hashCode() : 0);
			_result = 31 * _result + (splmtryData != null ? splmtryData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativesTradeMarginDataReportV01 {" +
				"rptHdr=" + this.rptHdr + ", " +
				"tradData=" + this.tradData + ", " +
				"splmtryData=" + this.splmtryData +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativesTradeMarginDataReportV01  ***********************/
	class DerivativesTradeMarginDataReportV01BuilderImpl implements DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder {
	
		protected TradeReportHeader4.TradeReportHeader4Builder rptHdr;
		protected TradeData55Choice.TradeData55ChoiceBuilder tradData;
		protected List<SupplementaryData1.SupplementaryData1Builder> splmtryData = new ArrayList<>();
		
		@Override
		@RosettaAttribute("rptHdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptHdr")
		public TradeReportHeader4.TradeReportHeader4Builder getRptHdr() {
			return rptHdr;
		}
		
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder getOrCreateRptHdr() {
			TradeReportHeader4.TradeReportHeader4Builder result;
			if (rptHdr!=null) {
				result = rptHdr;
			}
			else {
				result = rptHdr = TradeReportHeader4.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradData")
		public TradeData55Choice.TradeData55ChoiceBuilder getTradData() {
			return tradData;
		}
		
		@Override
		public TradeData55Choice.TradeData55ChoiceBuilder getOrCreateTradData() {
			TradeData55Choice.TradeData55ChoiceBuilder result;
			if (tradData!=null) {
				result = tradData;
			}
			else {
				result = tradData = TradeData55Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("splmtryData")
		public List<? extends SupplementaryData1.SupplementaryData1Builder> getSplmtryData() {
			return splmtryData;
		}
		
		@Override
		public SupplementaryData1.SupplementaryData1Builder getOrCreateSplmtryData(int index) {
			if (splmtryData==null) {
				this.splmtryData = new ArrayList<>();
			}
			return getIndex(splmtryData, index, () -> {
						SupplementaryData1.SupplementaryData1Builder newSplmtryData = SupplementaryData1.builder();
						return newSplmtryData;
					});
		}
		
		@RosettaAttribute("rptHdr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rptHdr")
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder setRptHdr(TradeReportHeader4 _rptHdr) {
			this.rptHdr = _rptHdr == null ? null : _rptHdr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradData")
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder setTradData(TradeData55Choice _tradData) {
			this.tradData = _tradData == null ? null : _tradData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("splmtryData")
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder addSplmtryData(SupplementaryData1 _splmtryData) {
			if (_splmtryData != null) {
				this.splmtryData.add(_splmtryData.toBuilder());
			}
			return this;
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder addSplmtryData(SupplementaryData1 _splmtryData, int idx) {
			getIndex(this.splmtryData, idx, () -> _splmtryData.toBuilder());
			return this;
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder addSplmtryData(List<? extends SupplementaryData1> splmtryDatas) {
			if (splmtryDatas != null) {
				for (final SupplementaryData1 toAdd : splmtryDatas) {
					this.splmtryData.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("splmtryData")
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder setSplmtryData(List<? extends SupplementaryData1> splmtryDatas) {
			if (splmtryDatas == null) {
				this.splmtryData = new ArrayList<>();
			} else {
				this.splmtryData = splmtryDatas.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01 build() {
			return new DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Impl(this);
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder prune() {
			if (rptHdr!=null && !rptHdr.prune().hasData()) rptHdr = null;
			if (tradData!=null && !tradData.prune().hasData()) tradData = null;
			splmtryData = splmtryData.stream().filter(b->b!=null).<SupplementaryData1.SupplementaryData1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRptHdr()!=null && getRptHdr().hasData()) return true;
			if (getTradData()!=null && getTradData().hasData()) return true;
			if (getSplmtryData()!=null && getSplmtryData().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder o = (DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder) other;
			
			merger.mergeRosetta(getRptHdr(), o.getRptHdr(), this::setRptHdr);
			merger.mergeRosetta(getTradData(), o.getTradData(), this::setTradData);
			merger.mergeRosetta(getSplmtryData(), o.getSplmtryData(), this::getOrCreateSplmtryData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativesTradeMarginDataReportV01 _that = getType().cast(o);
		
			if (!Objects.equals(rptHdr, _that.getRptHdr())) return false;
			if (!Objects.equals(tradData, _that.getTradData())) return false;
			if (!ListEquals.listEquals(splmtryData, _that.getSplmtryData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptHdr != null ? rptHdr.hashCode() : 0);
			_result = 31 * _result + (tradData != null ? tradData.hashCode() : 0);
			_result = 31 * _result + (splmtryData != null ? splmtryData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativesTradeMarginDataReportV01Builder {" +
				"rptHdr=" + this.rptHdr + ", " +
				"tradData=" + this.tradData + ", " +
				"splmtryData=" + this.splmtryData +
			'}';
		}
	}
}
