package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.TradeTransaction50__6Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides details of the trade transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeTransaction50__6", builder=TradeTransaction50__6.TradeTransaction50__6BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeTransaction50__6", model="iso20022", builder=TradeTransaction50__6.TradeTransaction50__6BuilderImpl.class, version="${project.version}")
public interface TradeTransaction50__6 extends RosettaModelObject {

	TradeTransaction50__6Meta metaData = new TradeTransaction50__6Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier as agreed with the counterparty.
	 */
	UniqueTransactionIdentifier2Choice__1 getTxId();
	/**
	 * Indication of the derivative event of the transaction.
	 */
	DerivativeEvent6__5 getDerivEvt();

	/*********************** Build Methods  ***********************/
	TradeTransaction50__6 build();
	
	TradeTransaction50__6.TradeTransaction50__6Builder toBuilder();
	
	static TradeTransaction50__6.TradeTransaction50__6Builder builder() {
		return new TradeTransaction50__6.TradeTransaction50__6BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeTransaction50__6> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeTransaction50__6> getType() {
		return TradeTransaction50__6.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.class, getTxId());
		processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__5.class, getDerivEvt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTransaction50__6Builder extends TradeTransaction50__6, RosettaModelObjectBuilder {
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getTxId();
		DerivativeEvent6__5.DerivativeEvent6__5Builder getOrCreateDerivEvt();
		@Override
		DerivativeEvent6__5.DerivativeEvent6__5Builder getDerivEvt();
		TradeTransaction50__6.TradeTransaction50__6Builder setTxId(UniqueTransactionIdentifier2Choice__1 txId);
		TradeTransaction50__6.TradeTransaction50__6Builder setDerivEvt(DerivativeEvent6__5 derivEvt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder.class, getTxId());
			processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__5.DerivativeEvent6__5Builder.class, getDerivEvt());
		}
		

		TradeTransaction50__6.TradeTransaction50__6Builder prune();
	}

	/*********************** Immutable Implementation of TradeTransaction50__6  ***********************/
	class TradeTransaction50__6Impl implements TradeTransaction50__6 {
		private final UniqueTransactionIdentifier2Choice__1 txId;
		private final DerivativeEvent6__5 derivEvt;
		
		protected TradeTransaction50__6Impl(TradeTransaction50__6.TradeTransaction50__6Builder builder) {
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
			this.derivEvt = ofNullable(builder.getDerivEvt()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice__1 getTxId() {
			return txId;
		}
		
		@Override
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("derivEvt")
		public DerivativeEvent6__5 getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		public TradeTransaction50__6 build() {
			return this;
		}
		
		@Override
		public TradeTransaction50__6.TradeTransaction50__6Builder toBuilder() {
			TradeTransaction50__6.TradeTransaction50__6Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeTransaction50__6.TradeTransaction50__6Builder builder) {
			ofNullable(getTxId()).ifPresent(builder::setTxId);
			ofNullable(getDerivEvt()).ifPresent(builder::setDerivEvt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction50__6 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction50__6 {" +
				"txId=" + this.txId + ", " +
				"derivEvt=" + this.derivEvt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTransaction50__6  ***********************/
	class TradeTransaction50__6BuilderImpl implements TradeTransaction50__6.TradeTransaction50__6Builder {
	
		protected UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder txId;
		protected DerivativeEvent6__5.DerivativeEvent6__5Builder derivEvt;
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getTxId() {
			return txId;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateTxId() {
			UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder result;
			if (txId!=null) {
				result = txId;
			}
			else {
				result = txId = UniqueTransactionIdentifier2Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("derivEvt")
		public DerivativeEvent6__5.DerivativeEvent6__5Builder getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder getOrCreateDerivEvt() {
			DerivativeEvent6__5.DerivativeEvent6__5Builder result;
			if (derivEvt!=null) {
				result = derivEvt;
			}
			else {
				result = derivEvt = DerivativeEvent6__5.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("txId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txId")
		@Override
		public TradeTransaction50__6.TradeTransaction50__6Builder setTxId(UniqueTransactionIdentifier2Choice__1 _txId) {
			this.txId = _txId == null ? null : _txId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("derivEvt")
		@Override
		public TradeTransaction50__6.TradeTransaction50__6Builder setDerivEvt(DerivativeEvent6__5 _derivEvt) {
			this.derivEvt = _derivEvt == null ? null : _derivEvt.toBuilder();
			return this;
		}
		
		@Override
		public TradeTransaction50__6 build() {
			return new TradeTransaction50__6.TradeTransaction50__6Impl(this);
		}
		
		@Override
		public TradeTransaction50__6.TradeTransaction50__6Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction50__6.TradeTransaction50__6Builder prune() {
			if (txId!=null && !txId.prune().hasData()) txId = null;
			if (derivEvt!=null && !derivEvt.prune().hasData()) derivEvt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTxId()!=null && getTxId().hasData()) return true;
			if (getDerivEvt()!=null && getDerivEvt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction50__6.TradeTransaction50__6Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeTransaction50__6.TradeTransaction50__6Builder o = (TradeTransaction50__6.TradeTransaction50__6Builder) other;
			
			merger.mergeRosetta(getTxId(), o.getTxId(), this::setTxId);
			merger.mergeRosetta(getDerivEvt(), o.getDerivEvt(), this::setDerivEvt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction50__6 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction50__6Builder {" +
				"txId=" + this.txId + ", " +
				"derivEvt=" + this.derivEvt +
			'}';
		}
	}
}
