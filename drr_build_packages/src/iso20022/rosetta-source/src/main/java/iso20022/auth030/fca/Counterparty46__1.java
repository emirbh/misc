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
import iso20022.auth030.fca.meta.Counterparty46__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to counterparty identification.
 * @version ${project.version}
 */
@RosettaDataType(value="Counterparty46__1", builder=Counterparty46__1.Counterparty46__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Counterparty46__1", model="iso20022", builder=Counterparty46__1.Counterparty46__1BuilderImpl.class, version="${project.version}")
public interface Counterparty46__1 extends RosettaModelObject {

	Counterparty46__1Meta metaData = new Counterparty46__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates if the counterparty is a legal entity or a natural person.
	 */
	PartyIdentification248Choice__2 getIdTp();
	/**
	 * Indicates if the counterparty is a central counterparty, a financial, non-financial counterparty or other type of counterparty in accordance with regulation.
	 */
	CounterpartyTradeNature15Choice__2 getNtr();
	/**
	 * Indicator of whether the counterparty 2 has the reporting obligation (irrespective of who is responsible and legally liable for its reporting).  Usage: If the element is not present, the ReportingObligation is False.
	 */
	Boolean getRptgOblgtn();

	/*********************** Build Methods  ***********************/
	Counterparty46__1 build();
	
	Counterparty46__1.Counterparty46__1Builder toBuilder();
	
	static Counterparty46__1.Counterparty46__1Builder builder() {
		return new Counterparty46__1.Counterparty46__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Counterparty46__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Counterparty46__1> getType() {
		return Counterparty46__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("idTp"), processor, PartyIdentification248Choice__2.class, getIdTp());
		processRosetta(path.newSubPath("ntr"), processor, CounterpartyTradeNature15Choice__2.class, getNtr());
		processor.processBasic(path.newSubPath("rptgOblgtn"), Boolean.class, getRptgOblgtn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Counterparty46__1Builder extends Counterparty46__1, RosettaModelObjectBuilder {
		PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder getOrCreateIdTp();
		@Override
		PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder getIdTp();
		CounterpartyTradeNature15Choice__2.CounterpartyTradeNature15Choice__2Builder getOrCreateNtr();
		@Override
		CounterpartyTradeNature15Choice__2.CounterpartyTradeNature15Choice__2Builder getNtr();
		Counterparty46__1.Counterparty46__1Builder setIdTp(PartyIdentification248Choice__2 idTp);
		Counterparty46__1.Counterparty46__1Builder setNtr(CounterpartyTradeNature15Choice__2 ntr);
		Counterparty46__1.Counterparty46__1Builder setRptgOblgtn(Boolean rptgOblgtn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("idTp"), processor, PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder.class, getIdTp());
			processRosetta(path.newSubPath("ntr"), processor, CounterpartyTradeNature15Choice__2.CounterpartyTradeNature15Choice__2Builder.class, getNtr());
			processor.processBasic(path.newSubPath("rptgOblgtn"), Boolean.class, getRptgOblgtn(), this);
		}
		

		Counterparty46__1.Counterparty46__1Builder prune();
	}

	/*********************** Immutable Implementation of Counterparty46__1  ***********************/
	class Counterparty46__1Impl implements Counterparty46__1 {
		private final PartyIdentification248Choice__2 idTp;
		private final CounterpartyTradeNature15Choice__2 ntr;
		private final Boolean rptgOblgtn;
		
		protected Counterparty46__1Impl(Counterparty46__1.Counterparty46__1Builder builder) {
			this.idTp = ofNullable(builder.getIdTp()).map(f->f.build()).orElse(null);
			this.ntr = ofNullable(builder.getNtr()).map(f->f.build()).orElse(null);
			this.rptgOblgtn = builder.getRptgOblgtn();
		}
		
		@Override
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("idTp")
		public PartyIdentification248Choice__2 getIdTp() {
			return idTp;
		}
		
		@Override
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntr")
		public CounterpartyTradeNature15Choice__2 getNtr() {
			return ntr;
		}
		
		@Override
		@RosettaAttribute("rptgOblgtn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgOblgtn")
		public Boolean getRptgOblgtn() {
			return rptgOblgtn;
		}
		
		@Override
		public Counterparty46__1 build() {
			return this;
		}
		
		@Override
		public Counterparty46__1.Counterparty46__1Builder toBuilder() {
			Counterparty46__1.Counterparty46__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Counterparty46__1.Counterparty46__1Builder builder) {
			ofNullable(getIdTp()).ifPresent(builder::setIdTp);
			ofNullable(getNtr()).ifPresent(builder::setNtr);
			ofNullable(getRptgOblgtn()).ifPresent(builder::setRptgOblgtn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty46__1 _that = getType().cast(o);
		
			if (!Objects.equals(idTp, _that.getIdTp())) return false;
			if (!Objects.equals(ntr, _that.getNtr())) return false;
			if (!Objects.equals(rptgOblgtn, _that.getRptgOblgtn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (idTp != null ? idTp.hashCode() : 0);
			_result = 31 * _result + (ntr != null ? ntr.hashCode() : 0);
			_result = 31 * _result + (rptgOblgtn != null ? rptgOblgtn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty46__1 {" +
				"idTp=" + this.idTp + ", " +
				"ntr=" + this.ntr + ", " +
				"rptgOblgtn=" + this.rptgOblgtn +
			'}';
		}
	}

	/*********************** Builder Implementation of Counterparty46__1  ***********************/
	class Counterparty46__1BuilderImpl implements Counterparty46__1.Counterparty46__1Builder {
	
		protected PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder idTp;
		protected CounterpartyTradeNature15Choice__2.CounterpartyTradeNature15Choice__2Builder ntr;
		protected Boolean rptgOblgtn;
		
		@Override
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("idTp")
		public PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder getIdTp() {
			return idTp;
		}
		
		@Override
		public PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder getOrCreateIdTp() {
			PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder result;
			if (idTp!=null) {
				result = idTp;
			}
			else {
				result = idTp = PartyIdentification248Choice__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntr")
		public CounterpartyTradeNature15Choice__2.CounterpartyTradeNature15Choice__2Builder getNtr() {
			return ntr;
		}
		
		@Override
		public CounterpartyTradeNature15Choice__2.CounterpartyTradeNature15Choice__2Builder getOrCreateNtr() {
			CounterpartyTradeNature15Choice__2.CounterpartyTradeNature15Choice__2Builder result;
			if (ntr!=null) {
				result = ntr;
			}
			else {
				result = ntr = CounterpartyTradeNature15Choice__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rptgOblgtn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgOblgtn")
		public Boolean getRptgOblgtn() {
			return rptgOblgtn;
		}
		
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("idTp")
		@Override
		public Counterparty46__1.Counterparty46__1Builder setIdTp(PartyIdentification248Choice__2 _idTp) {
			this.idTp = _idTp == null ? null : _idTp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntr")
		@Override
		public Counterparty46__1.Counterparty46__1Builder setNtr(CounterpartyTradeNature15Choice__2 _ntr) {
			this.ntr = _ntr == null ? null : _ntr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rptgOblgtn")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rptgOblgtn")
		@Override
		public Counterparty46__1.Counterparty46__1Builder setRptgOblgtn(Boolean _rptgOblgtn) {
			this.rptgOblgtn = _rptgOblgtn == null ? null : _rptgOblgtn;
			return this;
		}
		
		@Override
		public Counterparty46__1 build() {
			return new Counterparty46__1.Counterparty46__1Impl(this);
		}
		
		@Override
		public Counterparty46__1.Counterparty46__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty46__1.Counterparty46__1Builder prune() {
			if (idTp!=null && !idTp.prune().hasData()) idTp = null;
			if (ntr!=null && !ntr.prune().hasData()) ntr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdTp()!=null && getIdTp().hasData()) return true;
			if (getNtr()!=null && getNtr().hasData()) return true;
			if (getRptgOblgtn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty46__1.Counterparty46__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Counterparty46__1.Counterparty46__1Builder o = (Counterparty46__1.Counterparty46__1Builder) other;
			
			merger.mergeRosetta(getIdTp(), o.getIdTp(), this::setIdTp);
			merger.mergeRosetta(getNtr(), o.getNtr(), this::setNtr);
			
			merger.mergeBasic(getRptgOblgtn(), o.getRptgOblgtn(), this::setRptgOblgtn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty46__1 _that = getType().cast(o);
		
			if (!Objects.equals(idTp, _that.getIdTp())) return false;
			if (!Objects.equals(ntr, _that.getNtr())) return false;
			if (!Objects.equals(rptgOblgtn, _that.getRptgOblgtn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (idTp != null ? idTp.hashCode() : 0);
			_result = 31 * _result + (ntr != null ? ntr.hashCode() : 0);
			_result = 31 * _result + (rptgOblgtn != null ? rptgOblgtn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty46__1Builder {" +
				"idTp=" + this.idTp + ", " +
				"ntr=" + this.ntr + ", " +
				"rptgOblgtn=" + this.rptgOblgtn +
			'}';
		}
	}
}
