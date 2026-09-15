package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.Counterparty46__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to counterparty identification.
 * @version ${project.version}
 */
@RosettaDataType(value="Counterparty46__2", builder=Counterparty46__2.Counterparty46__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Counterparty46__2", model="iso20022", builder=Counterparty46__2.Counterparty46__2BuilderImpl.class, version="${project.version}")
public interface Counterparty46__2 extends RosettaModelObject {

	Counterparty46__2Meta metaData = new Counterparty46__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates if the counterparty is a legal entity or a natural person.
	 */
	PartyIdentification248Choice__5 getIdTp();

	/*********************** Build Methods  ***********************/
	Counterparty46__2 build();
	
	Counterparty46__2.Counterparty46__2Builder toBuilder();
	
	static Counterparty46__2.Counterparty46__2Builder builder() {
		return new Counterparty46__2.Counterparty46__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Counterparty46__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Counterparty46__2> getType() {
		return Counterparty46__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("idTp"), processor, PartyIdentification248Choice__5.class, getIdTp());
	}
	

	/*********************** Builder Interface  ***********************/
	interface Counterparty46__2Builder extends Counterparty46__2, RosettaModelObjectBuilder {
		PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder getOrCreateIdTp();
		@Override
		PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder getIdTp();
		Counterparty46__2.Counterparty46__2Builder setIdTp(PartyIdentification248Choice__5 idTp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("idTp"), processor, PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder.class, getIdTp());
		}
		

		Counterparty46__2.Counterparty46__2Builder prune();
	}

	/*********************** Immutable Implementation of Counterparty46__2  ***********************/
	class Counterparty46__2Impl implements Counterparty46__2 {
		private final PartyIdentification248Choice__5 idTp;
		
		protected Counterparty46__2Impl(Counterparty46__2.Counterparty46__2Builder builder) {
			this.idTp = ofNullable(builder.getIdTp()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("idTp")
		public PartyIdentification248Choice__5 getIdTp() {
			return idTp;
		}
		
		@Override
		public Counterparty46__2 build() {
			return this;
		}
		
		@Override
		public Counterparty46__2.Counterparty46__2Builder toBuilder() {
			Counterparty46__2.Counterparty46__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Counterparty46__2.Counterparty46__2Builder builder) {
			ofNullable(getIdTp()).ifPresent(builder::setIdTp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty46__2 _that = getType().cast(o);
		
			if (!Objects.equals(idTp, _that.getIdTp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (idTp != null ? idTp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty46__2 {" +
				"idTp=" + this.idTp +
			'}';
		}
	}

	/*********************** Builder Implementation of Counterparty46__2  ***********************/
	class Counterparty46__2BuilderImpl implements Counterparty46__2.Counterparty46__2Builder {
	
		protected PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder idTp;
		
		@Override
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("idTp")
		public PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder getIdTp() {
			return idTp;
		}
		
		@Override
		public PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder getOrCreateIdTp() {
			PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder result;
			if (idTp!=null) {
				result = idTp;
			}
			else {
				result = idTp = PartyIdentification248Choice__5.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("idTp")
		@Override
		public Counterparty46__2.Counterparty46__2Builder setIdTp(PartyIdentification248Choice__5 _idTp) {
			this.idTp = _idTp == null ? null : _idTp.toBuilder();
			return this;
		}
		
		@Override
		public Counterparty46__2 build() {
			return new Counterparty46__2.Counterparty46__2Impl(this);
		}
		
		@Override
		public Counterparty46__2.Counterparty46__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty46__2.Counterparty46__2Builder prune() {
			if (idTp!=null && !idTp.prune().hasData()) idTp = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdTp()!=null && getIdTp().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty46__2.Counterparty46__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Counterparty46__2.Counterparty46__2Builder o = (Counterparty46__2.Counterparty46__2Builder) other;
			
			merger.mergeRosetta(getIdTp(), o.getIdTp(), this::setIdTp);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty46__2 _that = getType().cast(o);
		
			if (!Objects.equals(idTp, _that.getIdTp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (idTp != null ? idTp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty46__2Builder {" +
				"idTp=" + this.idTp +
			'}';
		}
	}
}
