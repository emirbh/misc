package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.Counterparty45__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Counterparty45__3", builder=Counterparty45__3.Counterparty45__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Counterparty45__3", model="iso20022", builder=Counterparty45__3.Counterparty45__3BuilderImpl.class, version="${project.version}")
public interface Counterparty45__3 extends RosettaModelObject {

	Counterparty45__3Meta metaData = new Counterparty45__3Meta();

	/*********************** Getter Methods  ***********************/
	PartyIdentification248Choice__1 getId();
	ReportingExemption1__1 getRptgXmptn();

	/*********************** Build Methods  ***********************/
	Counterparty45__3 build();
	
	Counterparty45__3.Counterparty45__3Builder toBuilder();
	
	static Counterparty45__3.Counterparty45__3Builder builder() {
		return new Counterparty45__3.Counterparty45__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Counterparty45__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Counterparty45__3> getType() {
		return Counterparty45__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, PartyIdentification248Choice__1.class, getId());
		processRosetta(path.newSubPath("rptgXmptn"), processor, ReportingExemption1__1.class, getRptgXmptn());
	}
	

	/*********************** Builder Interface  ***********************/
	interface Counterparty45__3Builder extends Counterparty45__3, RosettaModelObjectBuilder {
		PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder getOrCreateId();
		@Override
		PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder getId();
		ReportingExemption1__1.ReportingExemption1__1Builder getOrCreateRptgXmptn();
		@Override
		ReportingExemption1__1.ReportingExemption1__1Builder getRptgXmptn();
		Counterparty45__3.Counterparty45__3Builder setId(PartyIdentification248Choice__1 id);
		Counterparty45__3.Counterparty45__3Builder setRptgXmptn(ReportingExemption1__1 rptgXmptn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder.class, getId());
			processRosetta(path.newSubPath("rptgXmptn"), processor, ReportingExemption1__1.ReportingExemption1__1Builder.class, getRptgXmptn());
		}
		

		Counterparty45__3.Counterparty45__3Builder prune();
	}

	/*********************** Immutable Implementation of Counterparty45__3  ***********************/
	class Counterparty45__3Impl implements Counterparty45__3 {
		private final PartyIdentification248Choice__1 id;
		private final ReportingExemption1__1 rptgXmptn;
		
		protected Counterparty45__3Impl(Counterparty45__3.Counterparty45__3Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.rptgXmptn = ofNullable(builder.getRptgXmptn()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("rptgXmptn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptgXmptn")
		public ReportingExemption1__1 getRptgXmptn() {
			return rptgXmptn;
		}
		
		@Override
		public Counterparty45__3 build() {
			return this;
		}
		
		@Override
		public Counterparty45__3.Counterparty45__3Builder toBuilder() {
			Counterparty45__3.Counterparty45__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Counterparty45__3.Counterparty45__3Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getRptgXmptn()).ifPresent(builder::setRptgXmptn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty45__3 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(rptgXmptn, _that.getRptgXmptn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (rptgXmptn != null ? rptgXmptn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty45__3 {" +
				"id=" + this.id + ", " +
				"rptgXmptn=" + this.rptgXmptn +
			'}';
		}
	}

	/*********************** Builder Implementation of Counterparty45__3  ***********************/
	class Counterparty45__3BuilderImpl implements Counterparty45__3.Counterparty45__3Builder {
	
		protected PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder id;
		protected ReportingExemption1__1.ReportingExemption1__1Builder rptgXmptn;
		
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
		@RosettaAttribute("rptgXmptn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptgXmptn")
		public ReportingExemption1__1.ReportingExemption1__1Builder getRptgXmptn() {
			return rptgXmptn;
		}
		
		@Override
		public ReportingExemption1__1.ReportingExemption1__1Builder getOrCreateRptgXmptn() {
			ReportingExemption1__1.ReportingExemption1__1Builder result;
			if (rptgXmptn!=null) {
				result = rptgXmptn;
			}
			else {
				result = rptgXmptn = ReportingExemption1__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public Counterparty45__3.Counterparty45__3Builder setId(PartyIdentification248Choice__1 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rptgXmptn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rptgXmptn")
		@Override
		public Counterparty45__3.Counterparty45__3Builder setRptgXmptn(ReportingExemption1__1 _rptgXmptn) {
			this.rptgXmptn = _rptgXmptn == null ? null : _rptgXmptn.toBuilder();
			return this;
		}
		
		@Override
		public Counterparty45__3 build() {
			return new Counterparty45__3.Counterparty45__3Impl(this);
		}
		
		@Override
		public Counterparty45__3.Counterparty45__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty45__3.Counterparty45__3Builder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			if (rptgXmptn!=null && !rptgXmptn.prune().hasData()) rptgXmptn = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null && getId().hasData()) return true;
			if (getRptgXmptn()!=null && getRptgXmptn().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty45__3.Counterparty45__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Counterparty45__3.Counterparty45__3Builder o = (Counterparty45__3.Counterparty45__3Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(getRptgXmptn(), o.getRptgXmptn(), this::setRptgXmptn);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty45__3 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(rptgXmptn, _that.getRptgXmptn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (rptgXmptn != null ? rptgXmptn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty45__3Builder {" +
				"id=" + this.id + ", " +
				"rptgXmptn=" + this.rptgXmptn +
			'}';
		}
	}
}
