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
import iso20022.auth030.fca.meta.CommonTradeDataReport69__4Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to contract and transaction details.
 * @version ${project.version}
 */
@RosettaDataType(value="CommonTradeDataReport69__4", builder=CommonTradeDataReport69__4.CommonTradeDataReport69__4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CommonTradeDataReport69__4", model="iso20022", builder=CommonTradeDataReport69__4.CommonTradeDataReport69__4BuilderImpl.class, version="${project.version}")
public interface CommonTradeDataReport69__4 extends RosettaModelObject {

	CommonTradeDataReport69__4Meta metaData = new CommonTradeDataReport69__4Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Data related to a trade transaction.
	 */
	TradeTransaction49__4 getTxData();

	/*********************** Build Methods  ***********************/
	CommonTradeDataReport69__4 build();
	
	CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder toBuilder();
	
	static CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder builder() {
		return new CommonTradeDataReport69__4.CommonTradeDataReport69__4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonTradeDataReport69__4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonTradeDataReport69__4> getType() {
		return CommonTradeDataReport69__4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("txData"), processor, TradeTransaction49__4.class, getTxData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonTradeDataReport69__4Builder extends CommonTradeDataReport69__4, RosettaModelObjectBuilder {
		TradeTransaction49__4.TradeTransaction49__4Builder getOrCreateTxData();
		@Override
		TradeTransaction49__4.TradeTransaction49__4Builder getTxData();
		CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder setTxData(TradeTransaction49__4 txData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("txData"), processor, TradeTransaction49__4.TradeTransaction49__4Builder.class, getTxData());
		}
		

		CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder prune();
	}

	/*********************** Immutable Implementation of CommonTradeDataReport69__4  ***********************/
	class CommonTradeDataReport69__4Impl implements CommonTradeDataReport69__4 {
		private final TradeTransaction49__4 txData;
		
		protected CommonTradeDataReport69__4Impl(CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder builder) {
			this.txData = ofNullable(builder.getTxData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction49__4 getTxData() {
			return txData;
		}
		
		@Override
		public CommonTradeDataReport69__4 build() {
			return this;
		}
		
		@Override
		public CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder toBuilder() {
			CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder builder) {
			ofNullable(getTxData()).ifPresent(builder::setTxData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport69__4 _that = getType().cast(o);
		
			if (!Objects.equals(txData, _that.getTxData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txData != null ? txData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonTradeDataReport69__4 {" +
				"txData=" + this.txData +
			'}';
		}
	}

	/*********************** Builder Implementation of CommonTradeDataReport69__4  ***********************/
	class CommonTradeDataReport69__4BuilderImpl implements CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder {
	
		protected TradeTransaction49__4.TradeTransaction49__4Builder txData;
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction49__4.TradeTransaction49__4Builder getTxData() {
			return txData;
		}
		
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder getOrCreateTxData() {
			TradeTransaction49__4.TradeTransaction49__4Builder result;
			if (txData!=null) {
				result = txData;
			}
			else {
				result = txData = TradeTransaction49__4.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("txData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txData")
		@Override
		public CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder setTxData(TradeTransaction49__4 _txData) {
			this.txData = _txData == null ? null : _txData.toBuilder();
			return this;
		}
		
		@Override
		public CommonTradeDataReport69__4 build() {
			return new CommonTradeDataReport69__4.CommonTradeDataReport69__4Impl(this);
		}
		
		@Override
		public CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder prune() {
			if (txData!=null && !txData.prune().hasData()) txData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTxData()!=null && getTxData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder o = (CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder) other;
			
			merger.mergeRosetta(getTxData(), o.getTxData(), this::setTxData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport69__4 _that = getType().cast(o);
		
			if (!Objects.equals(txData, _that.getTxData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txData != null ? txData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonTradeDataReport69__4Builder {" +
				"txData=" + this.txData +
			'}';
		}
	}
}
