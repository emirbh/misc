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
import iso20022.auth030.fca.meta.Counterparty45__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to counterparty identification.
 * @version ${project.version}
 */
@RosettaDataType(value="Counterparty45__1", builder=Counterparty45__1.Counterparty45__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Counterparty45__1", model="iso20022", builder=Counterparty45__1.Counterparty45__1BuilderImpl.class, version="${project.version}")
public interface Counterparty45__1 extends RosettaModelObject {

	Counterparty45__1Meta metaData = new Counterparty45__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique code identifying the reporting counterparty of the contract.
	 */
	PartyIdentification248Choice__1 getId();
	/**
	 * Indicates if the reporting counterparty is a central counterparty, a financial, non-financial counterparty or other type of counterparty in accordance with regulation.
	 */
	CounterpartyTradeNature15Choice__1 getNtr();
	/**
	 * Indicates the direction or side of the derivative transaction from the perspective of the reporting counterparty.   Usage: CounterpartySide should be used for the instruments such as most forwards and forward-like contracts (except for foreign exchange forwards and foreign exchange non-deliverable forwards); most options and option-like contracts including swaptions, caps and floors; credit default swaps; variance, volatility and correlation swaps; contracts for difference and spreadbets.
	 */
	Direction4Choice__1 getDrctnOrSd();

	/*********************** Build Methods  ***********************/
	Counterparty45__1 build();
	
	Counterparty45__1.Counterparty45__1Builder toBuilder();
	
	static Counterparty45__1.Counterparty45__1Builder builder() {
		return new Counterparty45__1.Counterparty45__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Counterparty45__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Counterparty45__1> getType() {
		return Counterparty45__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, PartyIdentification248Choice__1.class, getId());
		processRosetta(path.newSubPath("ntr"), processor, CounterpartyTradeNature15Choice__1.class, getNtr());
		processRosetta(path.newSubPath("drctnOrSd"), processor, Direction4Choice__1.class, getDrctnOrSd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface Counterparty45__1Builder extends Counterparty45__1, RosettaModelObjectBuilder {
		PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder getOrCreateId();
		@Override
		PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder getId();
		CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder getOrCreateNtr();
		@Override
		CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder getNtr();
		Direction4Choice__1.Direction4Choice__1Builder getOrCreateDrctnOrSd();
		@Override
		Direction4Choice__1.Direction4Choice__1Builder getDrctnOrSd();
		Counterparty45__1.Counterparty45__1Builder setId(PartyIdentification248Choice__1 id);
		Counterparty45__1.Counterparty45__1Builder setNtr(CounterpartyTradeNature15Choice__1 ntr);
		Counterparty45__1.Counterparty45__1Builder setDrctnOrSd(Direction4Choice__1 drctnOrSd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder.class, getId());
			processRosetta(path.newSubPath("ntr"), processor, CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder.class, getNtr());
			processRosetta(path.newSubPath("drctnOrSd"), processor, Direction4Choice__1.Direction4Choice__1Builder.class, getDrctnOrSd());
		}
		

		Counterparty45__1.Counterparty45__1Builder prune();
	}

	/*********************** Immutable Implementation of Counterparty45__1  ***********************/
	class Counterparty45__1Impl implements Counterparty45__1 {
		private final PartyIdentification248Choice__1 id;
		private final CounterpartyTradeNature15Choice__1 ntr;
		private final Direction4Choice__1 drctnOrSd;
		
		protected Counterparty45__1Impl(Counterparty45__1.Counterparty45__1Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.ntr = ofNullable(builder.getNtr()).map(f->f.build()).orElse(null);
			this.drctnOrSd = ofNullable(builder.getDrctnOrSd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public PartyIdentification248Choice__1 getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ntr")
		public CounterpartyTradeNature15Choice__1 getNtr() {
			return ntr;
		}
		
		@Override
		@RosettaAttribute("drctnOrSd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("drctnOrSd")
		public Direction4Choice__1 getDrctnOrSd() {
			return drctnOrSd;
		}
		
		@Override
		public Counterparty45__1 build() {
			return this;
		}
		
		@Override
		public Counterparty45__1.Counterparty45__1Builder toBuilder() {
			Counterparty45__1.Counterparty45__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Counterparty45__1.Counterparty45__1Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getNtr()).ifPresent(builder::setNtr);
			ofNullable(getDrctnOrSd()).ifPresent(builder::setDrctnOrSd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty45__1 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(ntr, _that.getNtr())) return false;
			if (!Objects.equals(drctnOrSd, _that.getDrctnOrSd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (ntr != null ? ntr.hashCode() : 0);
			_result = 31 * _result + (drctnOrSd != null ? drctnOrSd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty45__1 {" +
				"id=" + this.id + ", " +
				"ntr=" + this.ntr + ", " +
				"drctnOrSd=" + this.drctnOrSd +
			'}';
		}
	}

	/*********************** Builder Implementation of Counterparty45__1  ***********************/
	class Counterparty45__1BuilderImpl implements Counterparty45__1.Counterparty45__1Builder {
	
		protected PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder id;
		protected CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder ntr;
		protected Direction4Choice__1.Direction4Choice__1Builder drctnOrSd;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder getId() {
			return id;
		}
		
		@Override
		public PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder getOrCreateId() {
			PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = PartyIdentification248Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ntr")
		public CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder getNtr() {
			return ntr;
		}
		
		@Override
		public CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder getOrCreateNtr() {
			CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder result;
			if (ntr!=null) {
				result = ntr;
			}
			else {
				result = ntr = CounterpartyTradeNature15Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("drctnOrSd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("drctnOrSd")
		public Direction4Choice__1.Direction4Choice__1Builder getDrctnOrSd() {
			return drctnOrSd;
		}
		
		@Override
		public Direction4Choice__1.Direction4Choice__1Builder getOrCreateDrctnOrSd() {
			Direction4Choice__1.Direction4Choice__1Builder result;
			if (drctnOrSd!=null) {
				result = drctnOrSd;
			}
			else {
				result = drctnOrSd = Direction4Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public Counterparty45__1.Counterparty45__1Builder setId(PartyIdentification248Choice__1 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ntr")
		@Override
		public Counterparty45__1.Counterparty45__1Builder setNtr(CounterpartyTradeNature15Choice__1 _ntr) {
			this.ntr = _ntr == null ? null : _ntr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("drctnOrSd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("drctnOrSd")
		@Override
		public Counterparty45__1.Counterparty45__1Builder setDrctnOrSd(Direction4Choice__1 _drctnOrSd) {
			this.drctnOrSd = _drctnOrSd == null ? null : _drctnOrSd.toBuilder();
			return this;
		}
		
		@Override
		public Counterparty45__1 build() {
			return new Counterparty45__1.Counterparty45__1Impl(this);
		}
		
		@Override
		public Counterparty45__1.Counterparty45__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty45__1.Counterparty45__1Builder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			if (ntr!=null && !ntr.prune().hasData()) ntr = null;
			if (drctnOrSd!=null && !drctnOrSd.prune().hasData()) drctnOrSd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null && getId().hasData()) return true;
			if (getNtr()!=null && getNtr().hasData()) return true;
			if (getDrctnOrSd()!=null && getDrctnOrSd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty45__1.Counterparty45__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Counterparty45__1.Counterparty45__1Builder o = (Counterparty45__1.Counterparty45__1Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(getNtr(), o.getNtr(), this::setNtr);
			merger.mergeRosetta(getDrctnOrSd(), o.getDrctnOrSd(), this::setDrctnOrSd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty45__1 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(ntr, _that.getNtr())) return false;
			if (!Objects.equals(drctnOrSd, _that.getDrctnOrSd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (ntr != null ? ntr.hashCode() : 0);
			_result = 31 * _result + (drctnOrSd != null ? drctnOrSd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty45__1Builder {" +
				"id=" + this.id + ", " +
				"ntr=" + this.ntr + ", " +
				"drctnOrSd=" + this.drctnOrSd +
			'}';
		}
	}
}
