package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.TradeData42__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides details of a new trade transaction report.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeData42__2", builder=TradeData42__2.TradeData42__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeData42__2", model="iso20022", builder=TradeData42__2.TradeData42__2BuilderImpl.class, version="${project.version}")
public interface TradeData42__2 extends RosettaModelObject {

	TradeData42__2Meta metaData = new TradeData42__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Data specific to counterparties and related fields.
	 */
	CounterpartySpecificData36__2 getCtrPtySpcfcData();
	/**
	 * Data specifically related to transaction.
	 */
	CommonTradeDataReport69__2 getCmonTradData();
	/**
	 * Information concerning the reported transaction level type.  Usage: The absence of the code will imply the default value Transaction (TCTN).
	 */
	ModificationLevel1Code getLvl();

	/*********************** Build Methods  ***********************/
	TradeData42__2 build();
	
	TradeData42__2.TradeData42__2Builder toBuilder();
	
	static TradeData42__2.TradeData42__2Builder builder() {
		return new TradeData42__2.TradeData42__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeData42__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeData42__2> getType() {
		return TradeData42__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrPtySpcfcData"), processor, CounterpartySpecificData36__2.class, getCtrPtySpcfcData());
		processRosetta(path.newSubPath("cmonTradData"), processor, CommonTradeDataReport69__2.class, getCmonTradData());
		processor.processBasic(path.newSubPath("lvl"), ModificationLevel1Code.class, getLvl(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeData42__2Builder extends TradeData42__2, RosettaModelObjectBuilder {
		CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder getOrCreateCtrPtySpcfcData();
		@Override
		CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder getCtrPtySpcfcData();
		CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder getOrCreateCmonTradData();
		@Override
		CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder getCmonTradData();
		TradeData42__2.TradeData42__2Builder setCtrPtySpcfcData(CounterpartySpecificData36__2 ctrPtySpcfcData);
		TradeData42__2.TradeData42__2Builder setCmonTradData(CommonTradeDataReport69__2 cmonTradData);
		TradeData42__2.TradeData42__2Builder setLvl(ModificationLevel1Code lvl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrPtySpcfcData"), processor, CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder.class, getCtrPtySpcfcData());
			processRosetta(path.newSubPath("cmonTradData"), processor, CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder.class, getCmonTradData());
			processor.processBasic(path.newSubPath("lvl"), ModificationLevel1Code.class, getLvl(), this);
		}
		

		TradeData42__2.TradeData42__2Builder prune();
	}

	/*********************** Immutable Implementation of TradeData42__2  ***********************/
	class TradeData42__2Impl implements TradeData42__2 {
		private final CounterpartySpecificData36__2 ctrPtySpcfcData;
		private final CommonTradeDataReport69__2 cmonTradData;
		private final ModificationLevel1Code lvl;
		
		protected TradeData42__2Impl(TradeData42__2.TradeData42__2Builder builder) {
			this.ctrPtySpcfcData = ofNullable(builder.getCtrPtySpcfcData()).map(f->f.build()).orElse(null);
			this.cmonTradData = ofNullable(builder.getCmonTradData()).map(f->f.build()).orElse(null);
			this.lvl = builder.getLvl();
		}
		
		@Override
		@RosettaAttribute("ctrPtySpcfcData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPtySpcfcData")
		public CounterpartySpecificData36__2 getCtrPtySpcfcData() {
			return ctrPtySpcfcData;
		}
		
		@Override
		@RosettaAttribute("cmonTradData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cmonTradData")
		public CommonTradeDataReport69__2 getCmonTradData() {
			return cmonTradData;
		}
		
		@Override
		@RosettaAttribute("lvl")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lvl")
		public ModificationLevel1Code getLvl() {
			return lvl;
		}
		
		@Override
		public TradeData42__2 build() {
			return this;
		}
		
		@Override
		public TradeData42__2.TradeData42__2Builder toBuilder() {
			TradeData42__2.TradeData42__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeData42__2.TradeData42__2Builder builder) {
			ofNullable(getCtrPtySpcfcData()).ifPresent(builder::setCtrPtySpcfcData);
			ofNullable(getCmonTradData()).ifPresent(builder::setCmonTradData);
			ofNullable(getLvl()).ifPresent(builder::setLvl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData42__2 _that = getType().cast(o);
		
			if (!Objects.equals(ctrPtySpcfcData, _that.getCtrPtySpcfcData())) return false;
			if (!Objects.equals(cmonTradData, _that.getCmonTradData())) return false;
			if (!Objects.equals(lvl, _that.getLvl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrPtySpcfcData != null ? ctrPtySpcfcData.hashCode() : 0);
			_result = 31 * _result + (cmonTradData != null ? cmonTradData.hashCode() : 0);
			_result = 31 * _result + (lvl != null ? lvl.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeData42__2 {" +
				"ctrPtySpcfcData=" + this.ctrPtySpcfcData + ", " +
				"cmonTradData=" + this.cmonTradData + ", " +
				"lvl=" + this.lvl +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeData42__2  ***********************/
	class TradeData42__2BuilderImpl implements TradeData42__2.TradeData42__2Builder {
	
		protected CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder ctrPtySpcfcData;
		protected CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder cmonTradData;
		protected ModificationLevel1Code lvl;
		
		@Override
		@RosettaAttribute("ctrPtySpcfcData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPtySpcfcData")
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder getCtrPtySpcfcData() {
			return ctrPtySpcfcData;
		}
		
		@Override
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder getOrCreateCtrPtySpcfcData() {
			CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder result;
			if (ctrPtySpcfcData!=null) {
				result = ctrPtySpcfcData;
			}
			else {
				result = ctrPtySpcfcData = CounterpartySpecificData36__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cmonTradData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cmonTradData")
		public CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder getCmonTradData() {
			return cmonTradData;
		}
		
		@Override
		public CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder getOrCreateCmonTradData() {
			CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder result;
			if (cmonTradData!=null) {
				result = cmonTradData;
			}
			else {
				result = cmonTradData = CommonTradeDataReport69__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lvl")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lvl")
		public ModificationLevel1Code getLvl() {
			return lvl;
		}
		
		@RosettaAttribute("ctrPtySpcfcData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrPtySpcfcData")
		@Override
		public TradeData42__2.TradeData42__2Builder setCtrPtySpcfcData(CounterpartySpecificData36__2 _ctrPtySpcfcData) {
			this.ctrPtySpcfcData = _ctrPtySpcfcData == null ? null : _ctrPtySpcfcData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cmonTradData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cmonTradData")
		@Override
		public TradeData42__2.TradeData42__2Builder setCmonTradData(CommonTradeDataReport69__2 _cmonTradData) {
			this.cmonTradData = _cmonTradData == null ? null : _cmonTradData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lvl")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lvl")
		@Override
		public TradeData42__2.TradeData42__2Builder setLvl(ModificationLevel1Code _lvl) {
			this.lvl = _lvl == null ? null : _lvl;
			return this;
		}
		
		@Override
		public TradeData42__2 build() {
			return new TradeData42__2.TradeData42__2Impl(this);
		}
		
		@Override
		public TradeData42__2.TradeData42__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData42__2.TradeData42__2Builder prune() {
			if (ctrPtySpcfcData!=null && !ctrPtySpcfcData.prune().hasData()) ctrPtySpcfcData = null;
			if (cmonTradData!=null && !cmonTradData.prune().hasData()) cmonTradData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtrPtySpcfcData()!=null && getCtrPtySpcfcData().hasData()) return true;
			if (getCmonTradData()!=null && getCmonTradData().hasData()) return true;
			if (getLvl()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData42__2.TradeData42__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeData42__2.TradeData42__2Builder o = (TradeData42__2.TradeData42__2Builder) other;
			
			merger.mergeRosetta(getCtrPtySpcfcData(), o.getCtrPtySpcfcData(), this::setCtrPtySpcfcData);
			merger.mergeRosetta(getCmonTradData(), o.getCmonTradData(), this::setCmonTradData);
			
			merger.mergeBasic(getLvl(), o.getLvl(), this::setLvl);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData42__2 _that = getType().cast(o);
		
			if (!Objects.equals(ctrPtySpcfcData, _that.getCtrPtySpcfcData())) return false;
			if (!Objects.equals(cmonTradData, _that.getCmonTradData())) return false;
			if (!Objects.equals(lvl, _that.getLvl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrPtySpcfcData != null ? ctrPtySpcfcData.hashCode() : 0);
			_result = 31 * _result + (cmonTradData != null ? cmonTradData.hashCode() : 0);
			_result = 31 * _result + (lvl != null ? lvl.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeData42__2Builder {" +
				"ctrPtySpcfcData=" + this.ctrPtySpcfcData + ", " +
				"cmonTradData=" + this.cmonTradData + ", " +
				"lvl=" + this.lvl +
			'}';
		}
	}
}
