package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.CommonTradeDataReport71__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommonTradeDataReport71__3", builder=CommonTradeDataReport71__3.CommonTradeDataReport71__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CommonTradeDataReport71__3", model="iso20022", builder=CommonTradeDataReport71__3.CommonTradeDataReport71__3BuilderImpl.class, version="${project.version}")
public interface CommonTradeDataReport71__3 extends RosettaModelObject {

	CommonTradeDataReport71__3Meta metaData = new CommonTradeDataReport71__3Meta();

	/*********************** Getter Methods  ***********************/
	ContractType15__1 getCtrctData();
	TradeTransaction50__3 getTxData();

	/*********************** Build Methods  ***********************/
	CommonTradeDataReport71__3 build();
	
	CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder toBuilder();
	
	static CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder builder() {
		return new CommonTradeDataReport71__3.CommonTradeDataReport71__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonTradeDataReport71__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonTradeDataReport71__3> getType() {
		return CommonTradeDataReport71__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrctData"), processor, ContractType15__1.class, getCtrctData());
		processRosetta(path.newSubPath("txData"), processor, TradeTransaction50__3.class, getTxData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonTradeDataReport71__3Builder extends CommonTradeDataReport71__3, RosettaModelObjectBuilder {
		ContractType15__1.ContractType15__1Builder getOrCreateCtrctData();
		@Override
		ContractType15__1.ContractType15__1Builder getCtrctData();
		TradeTransaction50__3.TradeTransaction50__3Builder getOrCreateTxData();
		@Override
		TradeTransaction50__3.TradeTransaction50__3Builder getTxData();
		CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder setCtrctData(ContractType15__1 ctrctData);
		CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder setTxData(TradeTransaction50__3 txData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrctData"), processor, ContractType15__1.ContractType15__1Builder.class, getCtrctData());
			processRosetta(path.newSubPath("txData"), processor, TradeTransaction50__3.TradeTransaction50__3Builder.class, getTxData());
		}
		

		CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder prune();
	}

	/*********************** Immutable Implementation of CommonTradeDataReport71__3  ***********************/
	class CommonTradeDataReport71__3Impl implements CommonTradeDataReport71__3 {
		private final ContractType15__1 ctrctData;
		private final TradeTransaction50__3 txData;
		
		protected CommonTradeDataReport71__3Impl(CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder builder) {
			this.ctrctData = ofNullable(builder.getCtrctData()).map(f->f.build()).orElse(null);
			this.txData = ofNullable(builder.getTxData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrctData")
		public ContractType15__1 getCtrctData() {
			return ctrctData;
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction50__3 getTxData() {
			return txData;
		}
		
		@Override
		public CommonTradeDataReport71__3 build() {
			return this;
		}
		
		@Override
		public CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder toBuilder() {
			CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder builder) {
			ofNullable(getCtrctData()).ifPresent(builder::setCtrctData);
			ofNullable(getTxData()).ifPresent(builder::setTxData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport71__3 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctData, _that.getCtrctData())) return false;
			if (!Objects.equals(txData, _that.getTxData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctData != null ? ctrctData.hashCode() : 0);
			_result = 31 * _result + (txData != null ? txData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonTradeDataReport71__3 {" +
				"ctrctData=" + this.ctrctData + ", " +
				"txData=" + this.txData +
			'}';
		}
	}

	/*********************** Builder Implementation of CommonTradeDataReport71__3  ***********************/
	class CommonTradeDataReport71__3BuilderImpl implements CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder {
	
		protected ContractType15__1.ContractType15__1Builder ctrctData;
		protected TradeTransaction50__3.TradeTransaction50__3Builder txData;
		
		@Override
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrctData")
		public ContractType15__1.ContractType15__1Builder getCtrctData() {
			return ctrctData;
		}
		
		@Override
		public ContractType15__1.ContractType15__1Builder getOrCreateCtrctData() {
			ContractType15__1.ContractType15__1Builder result;
			if (ctrctData!=null) {
				result = ctrctData;
			}
			else {
				result = ctrctData = ContractType15__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction50__3.TradeTransaction50__3Builder getTxData() {
			return txData;
		}
		
		@Override
		public TradeTransaction50__3.TradeTransaction50__3Builder getOrCreateTxData() {
			TradeTransaction50__3.TradeTransaction50__3Builder result;
			if (txData!=null) {
				result = txData;
			}
			else {
				result = txData = TradeTransaction50__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctrctData")
		@Override
		public CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder setCtrctData(ContractType15__1 _ctrctData) {
			this.ctrctData = _ctrctData == null ? null : _ctrctData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("txData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txData")
		@Override
		public CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder setTxData(TradeTransaction50__3 _txData) {
			this.txData = _txData == null ? null : _txData.toBuilder();
			return this;
		}
		
		@Override
		public CommonTradeDataReport71__3 build() {
			return new CommonTradeDataReport71__3.CommonTradeDataReport71__3Impl(this);
		}
		
		@Override
		public CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder prune() {
			if (ctrctData!=null && !ctrctData.prune().hasData()) ctrctData = null;
			if (txData!=null && !txData.prune().hasData()) txData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtrctData()!=null && getCtrctData().hasData()) return true;
			if (getTxData()!=null && getTxData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder o = (CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder) other;
			
			merger.mergeRosetta(getCtrctData(), o.getCtrctData(), this::setCtrctData);
			merger.mergeRosetta(getTxData(), o.getTxData(), this::setTxData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport71__3 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctData, _that.getCtrctData())) return false;
			if (!Objects.equals(txData, _that.getTxData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctData != null ? ctrctData.hashCode() : 0);
			_result = 31 * _result + (txData != null ? txData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonTradeDataReport71__3Builder {" +
				"ctrctData=" + this.ctrctData + ", " +
				"txData=" + this.txData +
			'}';
		}
	}
}
