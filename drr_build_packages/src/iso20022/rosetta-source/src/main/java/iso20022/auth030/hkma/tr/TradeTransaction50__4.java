package iso20022.auth030.hkma.tr;

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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import iso20022.auth030.hkma.tr.meta.TradeTransaction50__4Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides details of the trade transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeTransaction50__4", builder=TradeTransaction50__4.TradeTransaction50__4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeTransaction50__4", model="iso20022", builder=TradeTransaction50__4.TradeTransaction50__4BuilderImpl.class, version="${project.version}")
public interface TradeTransaction50__4 extends RosettaModelObject {

	TradeTransaction50__4Meta metaData = new TradeTransaction50__4Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier as agreed with the counterparty.
	 */
	UniqueTransactionIdentifier2Choice__1 getTxId();
	/**
	 * Indicates the effective date of the early termination of the reported derivative transaction.
	 */
	Date getEarlyTermntnDt();
	/**
	 * Indication of the derivative event of the transaction.
	 */
	DerivativeEvent6__4 getDerivEvt();
	/**
	 * Payment related to elements not reported in dedicated fields.
	 */
	List<? extends OtherPayment5__1> getOthrPmt();

	/*********************** Build Methods  ***********************/
	TradeTransaction50__4 build();
	
	TradeTransaction50__4.TradeTransaction50__4Builder toBuilder();
	
	static TradeTransaction50__4.TradeTransaction50__4Builder builder() {
		return new TradeTransaction50__4.TradeTransaction50__4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeTransaction50__4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeTransaction50__4> getType() {
		return TradeTransaction50__4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.class, getTxId());
		processor.processBasic(path.newSubPath("earlyTermntnDt"), Date.class, getEarlyTermntnDt(), this);
		processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__4.class, getDerivEvt());
		processRosetta(path.newSubPath("othrPmt"), processor, OtherPayment5__1.class, getOthrPmt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTransaction50__4Builder extends TradeTransaction50__4, RosettaModelObjectBuilder {
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getTxId();
		DerivativeEvent6__4.DerivativeEvent6__4Builder getOrCreateDerivEvt();
		@Override
		DerivativeEvent6__4.DerivativeEvent6__4Builder getDerivEvt();
		OtherPayment5__1.OtherPayment5__1Builder getOrCreateOthrPmt(int index);
		@Override
		List<? extends OtherPayment5__1.OtherPayment5__1Builder> getOthrPmt();
		TradeTransaction50__4.TradeTransaction50__4Builder setTxId(UniqueTransactionIdentifier2Choice__1 txId);
		TradeTransaction50__4.TradeTransaction50__4Builder setEarlyTermntnDt(Date earlyTermntnDt);
		TradeTransaction50__4.TradeTransaction50__4Builder setDerivEvt(DerivativeEvent6__4 derivEvt);
		TradeTransaction50__4.TradeTransaction50__4Builder addOthrPmt(OtherPayment5__1 othrPmt);
		TradeTransaction50__4.TradeTransaction50__4Builder addOthrPmt(OtherPayment5__1 othrPmt, int idx);
		TradeTransaction50__4.TradeTransaction50__4Builder addOthrPmt(List<? extends OtherPayment5__1> othrPmt);
		TradeTransaction50__4.TradeTransaction50__4Builder setOthrPmt(List<? extends OtherPayment5__1> othrPmt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder.class, getTxId());
			processor.processBasic(path.newSubPath("earlyTermntnDt"), Date.class, getEarlyTermntnDt(), this);
			processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__4.DerivativeEvent6__4Builder.class, getDerivEvt());
			processRosetta(path.newSubPath("othrPmt"), processor, OtherPayment5__1.OtherPayment5__1Builder.class, getOthrPmt());
		}
		

		TradeTransaction50__4.TradeTransaction50__4Builder prune();
	}

	/*********************** Immutable Implementation of TradeTransaction50__4  ***********************/
	class TradeTransaction50__4Impl implements TradeTransaction50__4 {
		private final UniqueTransactionIdentifier2Choice__1 txId;
		private final Date earlyTermntnDt;
		private final DerivativeEvent6__4 derivEvt;
		private final List<? extends OtherPayment5__1> othrPmt;
		
		protected TradeTransaction50__4Impl(TradeTransaction50__4.TradeTransaction50__4Builder builder) {
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
			this.earlyTermntnDt = builder.getEarlyTermntnDt();
			this.derivEvt = ofNullable(builder.getDerivEvt()).map(f->f.build()).orElse(null);
			this.othrPmt = ofNullable(builder.getOthrPmt()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("earlyTermntnDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTermntnDt")
		public Date getEarlyTermntnDt() {
			return earlyTermntnDt;
		}
		
		@Override
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivEvt")
		public DerivativeEvent6__4 getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		@RosettaAttribute("othrPmt")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("othrPmt")
		public List<? extends OtherPayment5__1> getOthrPmt() {
			return othrPmt;
		}
		
		@Override
		public TradeTransaction50__4 build() {
			return this;
		}
		
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder toBuilder() {
			TradeTransaction50__4.TradeTransaction50__4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeTransaction50__4.TradeTransaction50__4Builder builder) {
			ofNullable(getTxId()).ifPresent(builder::setTxId);
			ofNullable(getEarlyTermntnDt()).ifPresent(builder::setEarlyTermntnDt);
			ofNullable(getDerivEvt()).ifPresent(builder::setDerivEvt);
			ofNullable(getOthrPmt()).ifPresent(builder::setOthrPmt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction50__4 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(earlyTermntnDt, _that.getEarlyTermntnDt())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			if (!ListEquals.listEquals(othrPmt, _that.getOthrPmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (earlyTermntnDt != null ? earlyTermntnDt.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			_result = 31 * _result + (othrPmt != null ? othrPmt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction50__4 {" +
				"txId=" + this.txId + ", " +
				"earlyTermntnDt=" + this.earlyTermntnDt + ", " +
				"derivEvt=" + this.derivEvt + ", " +
				"othrPmt=" + this.othrPmt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTransaction50__4  ***********************/
	class TradeTransaction50__4BuilderImpl implements TradeTransaction50__4.TradeTransaction50__4Builder {
	
		protected UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder txId;
		protected Date earlyTermntnDt;
		protected DerivativeEvent6__4.DerivativeEvent6__4Builder derivEvt;
		protected List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt = new ArrayList<>();
		
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
		@RosettaAttribute("earlyTermntnDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTermntnDt")
		public Date getEarlyTermntnDt() {
			return earlyTermntnDt;
		}
		
		@Override
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivEvt")
		public DerivativeEvent6__4.DerivativeEvent6__4Builder getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		public DerivativeEvent6__4.DerivativeEvent6__4Builder getOrCreateDerivEvt() {
			DerivativeEvent6__4.DerivativeEvent6__4Builder result;
			if (derivEvt!=null) {
				result = derivEvt;
			}
			else {
				result = derivEvt = DerivativeEvent6__4.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othrPmt")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("othrPmt")
		public List<? extends OtherPayment5__1.OtherPayment5__1Builder> getOthrPmt() {
			return othrPmt;
		}
		
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder getOrCreateOthrPmt(int index) {
			if (othrPmt==null) {
				this.othrPmt = new ArrayList<>();
			}
			return getIndex(othrPmt, index, () -> {
						OtherPayment5__1.OtherPayment5__1Builder newOthrPmt = OtherPayment5__1.builder();
						return newOthrPmt;
					});
		}
		
		@RosettaAttribute("txId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txId")
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder setTxId(UniqueTransactionIdentifier2Choice__1 _txId) {
			this.txId = _txId == null ? null : _txId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("earlyTermntnDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTermntnDt")
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder setEarlyTermntnDt(Date _earlyTermntnDt) {
			this.earlyTermntnDt = _earlyTermntnDt == null ? null : _earlyTermntnDt;
			return this;
		}
		
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("derivEvt")
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder setDerivEvt(DerivativeEvent6__4 _derivEvt) {
			this.derivEvt = _derivEvt == null ? null : _derivEvt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othrPmt")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("othrPmt")
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder addOthrPmt(OtherPayment5__1 _othrPmt) {
			if (_othrPmt != null) {
				this.othrPmt.add(_othrPmt.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder addOthrPmt(OtherPayment5__1 _othrPmt, int idx) {
			getIndex(this.othrPmt, idx, () -> _othrPmt.toBuilder());
			return this;
		}
		
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder addOthrPmt(List<? extends OtherPayment5__1> othrPmts) {
			if (othrPmts != null) {
				for (final OtherPayment5__1 toAdd : othrPmts) {
					this.othrPmt.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("othrPmt")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("othrPmt")
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder setOthrPmt(List<? extends OtherPayment5__1> othrPmts) {
			if (othrPmts == null) {
				this.othrPmt = new ArrayList<>();
			} else {
				this.othrPmt = othrPmts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeTransaction50__4 build() {
			return new TradeTransaction50__4.TradeTransaction50__4Impl(this);
		}
		
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder prune() {
			if (txId!=null && !txId.prune().hasData()) txId = null;
			if (derivEvt!=null && !derivEvt.prune().hasData()) derivEvt = null;
			othrPmt = othrPmt.stream().filter(b->b!=null).<OtherPayment5__1.OtherPayment5__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTxId()!=null && getTxId().hasData()) return true;
			if (getEarlyTermntnDt()!=null) return true;
			if (getDerivEvt()!=null && getDerivEvt().hasData()) return true;
			if (getOthrPmt()!=null && getOthrPmt().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeTransaction50__4.TradeTransaction50__4Builder o = (TradeTransaction50__4.TradeTransaction50__4Builder) other;
			
			merger.mergeRosetta(getTxId(), o.getTxId(), this::setTxId);
			merger.mergeRosetta(getDerivEvt(), o.getDerivEvt(), this::setDerivEvt);
			merger.mergeRosetta(getOthrPmt(), o.getOthrPmt(), this::getOrCreateOthrPmt);
			
			merger.mergeBasic(getEarlyTermntnDt(), o.getEarlyTermntnDt(), this::setEarlyTermntnDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction50__4 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(earlyTermntnDt, _that.getEarlyTermntnDt())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			if (!ListEquals.listEquals(othrPmt, _that.getOthrPmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (earlyTermntnDt != null ? earlyTermntnDt.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			_result = 31 * _result + (othrPmt != null ? othrPmt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction50__4Builder {" +
				"txId=" + this.txId + ", " +
				"earlyTermntnDt=" + this.earlyTermntnDt + ", " +
				"derivEvt=" + this.derivEvt + ", " +
				"othrPmt=" + this.othrPmt +
			'}';
		}
	}
}
