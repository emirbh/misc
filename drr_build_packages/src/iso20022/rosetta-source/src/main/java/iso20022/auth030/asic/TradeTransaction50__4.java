package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.TradeTransaction50__4Meta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeTransaction50__4", builder=TradeTransaction50__4.TradeTransaction50__4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeTransaction50__4", model="iso20022", builder=TradeTransaction50__4.TradeTransaction50__4BuilderImpl.class, version="${project.version}")
public interface TradeTransaction50__4 extends RosettaModelObject {

	TradeTransaction50__4Meta metaData = new TradeTransaction50__4Meta();

	/*********************** Getter Methods  ***********************/
	UniqueTransactionIdentifier2Choice__1 getTxId();
	String getScndryTxId();
	ZonedDateTime getExctnTmStmp();
	DerivativeEvent6__1 getDerivEvt();
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
		processor.processBasic(path.newSubPath("scndryTxId"), String.class, getScndryTxId(), this);
		processor.processBasic(path.newSubPath("exctnTmStmp"), ZonedDateTime.class, getExctnTmStmp(), this);
		processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__1.class, getDerivEvt());
		processRosetta(path.newSubPath("othrPmt"), processor, OtherPayment5__1.class, getOthrPmt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTransaction50__4Builder extends TradeTransaction50__4, RosettaModelObjectBuilder {
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getTxId();
		DerivativeEvent6__1.DerivativeEvent6__1Builder getOrCreateDerivEvt();
		@Override
		DerivativeEvent6__1.DerivativeEvent6__1Builder getDerivEvt();
		OtherPayment5__1.OtherPayment5__1Builder getOrCreateOthrPmt(int index);
		@Override
		List<? extends OtherPayment5__1.OtherPayment5__1Builder> getOthrPmt();
		TradeTransaction50__4.TradeTransaction50__4Builder setTxId(UniqueTransactionIdentifier2Choice__1 txId);
		TradeTransaction50__4.TradeTransaction50__4Builder setScndryTxId(String scndryTxId);
		TradeTransaction50__4.TradeTransaction50__4Builder setExctnTmStmp(ZonedDateTime exctnTmStmp);
		TradeTransaction50__4.TradeTransaction50__4Builder setDerivEvt(DerivativeEvent6__1 derivEvt);
		TradeTransaction50__4.TradeTransaction50__4Builder addOthrPmt(OtherPayment5__1 othrPmt);
		TradeTransaction50__4.TradeTransaction50__4Builder addOthrPmt(OtherPayment5__1 othrPmt, int idx);
		TradeTransaction50__4.TradeTransaction50__4Builder addOthrPmt(List<? extends OtherPayment5__1> othrPmt);
		TradeTransaction50__4.TradeTransaction50__4Builder setOthrPmt(List<? extends OtherPayment5__1> othrPmt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder.class, getTxId());
			processor.processBasic(path.newSubPath("scndryTxId"), String.class, getScndryTxId(), this);
			processor.processBasic(path.newSubPath("exctnTmStmp"), ZonedDateTime.class, getExctnTmStmp(), this);
			processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__1.DerivativeEvent6__1Builder.class, getDerivEvt());
			processRosetta(path.newSubPath("othrPmt"), processor, OtherPayment5__1.OtherPayment5__1Builder.class, getOthrPmt());
		}
		

		TradeTransaction50__4.TradeTransaction50__4Builder prune();
	}

	/*********************** Immutable Implementation of TradeTransaction50__4  ***********************/
	class TradeTransaction50__4Impl implements TradeTransaction50__4 {
		private final UniqueTransactionIdentifier2Choice__1 txId;
		private final String scndryTxId;
		private final ZonedDateTime exctnTmStmp;
		private final DerivativeEvent6__1 derivEvt;
		private final List<? extends OtherPayment5__1> othrPmt;
		
		protected TradeTransaction50__4Impl(TradeTransaction50__4.TradeTransaction50__4Builder builder) {
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
			this.scndryTxId = builder.getScndryTxId();
			this.exctnTmStmp = builder.getExctnTmStmp();
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
		@RosettaAttribute("scndryTxId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndryTxId")
		public String getScndryTxId() {
			return scndryTxId;
		}
		
		@Override
		@RosettaAttribute("exctnTmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exctnTmStmp")
		public ZonedDateTime getExctnTmStmp() {
			return exctnTmStmp;
		}
		
		@Override
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivEvt")
		public DerivativeEvent6__1 getDerivEvt() {
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
			ofNullable(getScndryTxId()).ifPresent(builder::setScndryTxId);
			ofNullable(getExctnTmStmp()).ifPresent(builder::setExctnTmStmp);
			ofNullable(getDerivEvt()).ifPresent(builder::setDerivEvt);
			ofNullable(getOthrPmt()).ifPresent(builder::setOthrPmt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction50__4 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(scndryTxId, _that.getScndryTxId())) return false;
			if (!Objects.equals(exctnTmStmp, _that.getExctnTmStmp())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			if (!ListEquals.listEquals(othrPmt, _that.getOthrPmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (scndryTxId != null ? scndryTxId.hashCode() : 0);
			_result = 31 * _result + (exctnTmStmp != null ? exctnTmStmp.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			_result = 31 * _result + (othrPmt != null ? othrPmt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction50__4 {" +
				"txId=" + this.txId + ", " +
				"scndryTxId=" + this.scndryTxId + ", " +
				"exctnTmStmp=" + this.exctnTmStmp + ", " +
				"derivEvt=" + this.derivEvt + ", " +
				"othrPmt=" + this.othrPmt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTransaction50__4  ***********************/
	class TradeTransaction50__4BuilderImpl implements TradeTransaction50__4.TradeTransaction50__4Builder {
	
		protected UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder txId;
		protected String scndryTxId;
		protected ZonedDateTime exctnTmStmp;
		protected DerivativeEvent6__1.DerivativeEvent6__1Builder derivEvt;
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
		@RosettaAttribute("scndryTxId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndryTxId")
		public String getScndryTxId() {
			return scndryTxId;
		}
		
		@Override
		@RosettaAttribute("exctnTmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exctnTmStmp")
		public ZonedDateTime getExctnTmStmp() {
			return exctnTmStmp;
		}
		
		@Override
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivEvt")
		public DerivativeEvent6__1.DerivativeEvent6__1Builder getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		public DerivativeEvent6__1.DerivativeEvent6__1Builder getOrCreateDerivEvt() {
			DerivativeEvent6__1.DerivativeEvent6__1Builder result;
			if (derivEvt!=null) {
				result = derivEvt;
			}
			else {
				result = derivEvt = DerivativeEvent6__1.builder();
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
		
		@RosettaAttribute("scndryTxId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scndryTxId")
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder setScndryTxId(String _scndryTxId) {
			this.scndryTxId = _scndryTxId == null ? null : _scndryTxId;
			return this;
		}
		
		@RosettaAttribute("exctnTmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exctnTmStmp")
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder setExctnTmStmp(ZonedDateTime _exctnTmStmp) {
			this.exctnTmStmp = _exctnTmStmp == null ? null : _exctnTmStmp;
			return this;
		}
		
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("derivEvt")
		@Override
		public TradeTransaction50__4.TradeTransaction50__4Builder setDerivEvt(DerivativeEvent6__1 _derivEvt) {
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
			if (getScndryTxId()!=null) return true;
			if (getExctnTmStmp()!=null) return true;
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
			
			merger.mergeBasic(getScndryTxId(), o.getScndryTxId(), this::setScndryTxId);
			merger.mergeBasic(getExctnTmStmp(), o.getExctnTmStmp(), this::setExctnTmStmp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction50__4 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(scndryTxId, _that.getScndryTxId())) return false;
			if (!Objects.equals(exctnTmStmp, _that.getExctnTmStmp())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			if (!ListEquals.listEquals(othrPmt, _that.getOthrPmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (scndryTxId != null ? scndryTxId.hashCode() : 0);
			_result = 31 * _result + (exctnTmStmp != null ? exctnTmStmp.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			_result = 31 * _result + (othrPmt != null ? othrPmt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction50__4Builder {" +
				"txId=" + this.txId + ", " +
				"scndryTxId=" + this.scndryTxId + ", " +
				"exctnTmStmp=" + this.exctnTmStmp + ", " +
				"derivEvt=" + this.derivEvt + ", " +
				"othrPmt=" + this.othrPmt +
			'}';
		}
	}
}
