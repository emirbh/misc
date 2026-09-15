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
import iso20022.auth030.fca.meta.CommonTradeDataReport69__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to contract and transaction details.
 * @version ${project.version}
 */
@RosettaDataType(value="CommonTradeDataReport69__3", builder=CommonTradeDataReport69__3.CommonTradeDataReport69__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CommonTradeDataReport69__3", model="iso20022", builder=CommonTradeDataReport69__3.CommonTradeDataReport69__3BuilderImpl.class, version="${project.version}")
public interface CommonTradeDataReport69__3 extends RosettaModelObject {

	CommonTradeDataReport69__3Meta metaData = new CommonTradeDataReport69__3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Data related to a trade contract.
	 */
	ContractType14__1 getCtrctData();
	/**
	 * Data related to a trade transaction.
	 */
	TradeTransaction49__3 getTxData();

	/*********************** Build Methods  ***********************/
	CommonTradeDataReport69__3 build();
	
	CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder toBuilder();
	
	static CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder builder() {
		return new CommonTradeDataReport69__3.CommonTradeDataReport69__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonTradeDataReport69__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonTradeDataReport69__3> getType() {
		return CommonTradeDataReport69__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrctData"), processor, ContractType14__1.class, getCtrctData());
		processRosetta(path.newSubPath("txData"), processor, TradeTransaction49__3.class, getTxData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonTradeDataReport69__3Builder extends CommonTradeDataReport69__3, RosettaModelObjectBuilder {
		ContractType14__1.ContractType14__1Builder getOrCreateCtrctData();
		@Override
		ContractType14__1.ContractType14__1Builder getCtrctData();
		TradeTransaction49__3.TradeTransaction49__3Builder getOrCreateTxData();
		@Override
		TradeTransaction49__3.TradeTransaction49__3Builder getTxData();
		CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder setCtrctData(ContractType14__1 ctrctData);
		CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder setTxData(TradeTransaction49__3 txData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrctData"), processor, ContractType14__1.ContractType14__1Builder.class, getCtrctData());
			processRosetta(path.newSubPath("txData"), processor, TradeTransaction49__3.TradeTransaction49__3Builder.class, getTxData());
		}
		

		CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder prune();
	}

	/*********************** Immutable Implementation of CommonTradeDataReport69__3  ***********************/
	class CommonTradeDataReport69__3Impl implements CommonTradeDataReport69__3 {
		private final ContractType14__1 ctrctData;
		private final TradeTransaction49__3 txData;
		
		protected CommonTradeDataReport69__3Impl(CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder builder) {
			this.ctrctData = ofNullable(builder.getCtrctData()).map(f->f.build()).orElse(null);
			this.txData = ofNullable(builder.getTxData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrctData")
		public ContractType14__1 getCtrctData() {
			return ctrctData;
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction49__3 getTxData() {
			return txData;
		}
		
		@Override
		public CommonTradeDataReport69__3 build() {
			return this;
		}
		
		@Override
		public CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder toBuilder() {
			CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder builder) {
			ofNullable(getCtrctData()).ifPresent(builder::setCtrctData);
			ofNullable(getTxData()).ifPresent(builder::setTxData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport69__3 _that = getType().cast(o);
		
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
			return "CommonTradeDataReport69__3 {" +
				"ctrctData=" + this.ctrctData + ", " +
				"txData=" + this.txData +
			'}';
		}
	}

	/*********************** Builder Implementation of CommonTradeDataReport69__3  ***********************/
	class CommonTradeDataReport69__3BuilderImpl implements CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder {
	
		protected ContractType14__1.ContractType14__1Builder ctrctData;
		protected TradeTransaction49__3.TradeTransaction49__3Builder txData;
		
		@Override
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrctData")
		public ContractType14__1.ContractType14__1Builder getCtrctData() {
			return ctrctData;
		}
		
		@Override
		public ContractType14__1.ContractType14__1Builder getOrCreateCtrctData() {
			ContractType14__1.ContractType14__1Builder result;
			if (ctrctData!=null) {
				result = ctrctData;
			}
			else {
				result = ctrctData = ContractType14__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction49__3.TradeTransaction49__3Builder getTxData() {
			return txData;
		}
		
		@Override
		public TradeTransaction49__3.TradeTransaction49__3Builder getOrCreateTxData() {
			TradeTransaction49__3.TradeTransaction49__3Builder result;
			if (txData!=null) {
				result = txData;
			}
			else {
				result = txData = TradeTransaction49__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctrctData")
		@Override
		public CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder setCtrctData(ContractType14__1 _ctrctData) {
			this.ctrctData = _ctrctData == null ? null : _ctrctData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("txData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txData")
		@Override
		public CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder setTxData(TradeTransaction49__3 _txData) {
			this.txData = _txData == null ? null : _txData.toBuilder();
			return this;
		}
		
		@Override
		public CommonTradeDataReport69__3 build() {
			return new CommonTradeDataReport69__3.CommonTradeDataReport69__3Impl(this);
		}
		
		@Override
		public CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder prune() {
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
		public CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder o = (CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder) other;
			
			merger.mergeRosetta(getCtrctData(), o.getCtrctData(), this::setCtrctData);
			merger.mergeRosetta(getTxData(), o.getTxData(), this::setTxData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport69__3 _that = getType().cast(o);
		
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
			return "CommonTradeDataReport69__3Builder {" +
				"ctrctData=" + this.ctrctData + ", " +
				"txData=" + this.txData +
			'}';
		}
	}
}
