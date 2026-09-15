package iso20022.auth108.jfsa;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth108.jfsa.meta.Counterparty46__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Counterparty46__1", builder=Counterparty46__1.Counterparty46__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Counterparty46__1", model="iso20022", builder=Counterparty46__1.Counterparty46__1BuilderImpl.class, version="${project.version}")
public interface Counterparty46__1 extends RosettaModelObject {

	Counterparty46__1Meta metaData = new Counterparty46__1Meta();

	/*********************** Getter Methods  ***********************/
	PartyIdentification248Choice__2 getIdTp();

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
	}
	

	/*********************** Builder Interface  ***********************/
	interface Counterparty46__1Builder extends Counterparty46__1, RosettaModelObjectBuilder {
		PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder getOrCreateIdTp();
		@Override
		PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder getIdTp();
		Counterparty46__1.Counterparty46__1Builder setIdTp(PartyIdentification248Choice__2 idTp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("idTp"), processor, PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder.class, getIdTp());
		}
		

		Counterparty46__1.Counterparty46__1Builder prune();
	}

	/*********************** Immutable Implementation of Counterparty46__1  ***********************/
	class Counterparty46__1Impl implements Counterparty46__1 {
		private final PartyIdentification248Choice__2 idTp;
		
		protected Counterparty46__1Impl(Counterparty46__1.Counterparty46__1Builder builder) {
			this.idTp = ofNullable(builder.getIdTp()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("idTp")
		public PartyIdentification248Choice__2 getIdTp() {
			return idTp;
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
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty46__1 _that = getType().cast(o);
		
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
			return "Counterparty46__1 {" +
				"idTp=" + this.idTp +
			'}';
		}
	}

	/*********************** Builder Implementation of Counterparty46__1  ***********************/
	class Counterparty46__1BuilderImpl implements Counterparty46__1.Counterparty46__1Builder {
	
		protected PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder idTp;
		
		@Override
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.GETTER)
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
		
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("idTp")
		@Override
		public Counterparty46__1.Counterparty46__1Builder setIdTp(PartyIdentification248Choice__2 _idTp) {
			this.idTp = _idTp == null ? null : _idTp.toBuilder();
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
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdTp()!=null && getIdTp().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty46__1.Counterparty46__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Counterparty46__1.Counterparty46__1Builder o = (Counterparty46__1.Counterparty46__1Builder) other;
			
			merger.mergeRosetta(getIdTp(), o.getIdTp(), this::setIdTp);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty46__1 _that = getType().cast(o);
		
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
			return "Counterparty46__1Builder {" +
				"idTp=" + this.idTp +
			'}';
		}
	}
}
