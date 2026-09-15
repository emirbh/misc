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
import iso20022.auth030.asic.meta.Counterparty46__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Counterparty46__3", builder=Counterparty46__3.Counterparty46__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Counterparty46__3", model="iso20022", builder=Counterparty46__3.Counterparty46__3BuilderImpl.class, version="${project.version}")
public interface Counterparty46__3 extends RosettaModelObject {

	Counterparty46__3Meta metaData = new Counterparty46__3Meta();

	/*********************** Getter Methods  ***********************/
	PartyIdentification248Choice__3 getIdTp();

	/*********************** Build Methods  ***********************/
	Counterparty46__3 build();
	
	Counterparty46__3.Counterparty46__3Builder toBuilder();
	
	static Counterparty46__3.Counterparty46__3Builder builder() {
		return new Counterparty46__3.Counterparty46__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Counterparty46__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Counterparty46__3> getType() {
		return Counterparty46__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("idTp"), processor, PartyIdentification248Choice__3.class, getIdTp());
	}
	

	/*********************** Builder Interface  ***********************/
	interface Counterparty46__3Builder extends Counterparty46__3, RosettaModelObjectBuilder {
		PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder getOrCreateIdTp();
		@Override
		PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder getIdTp();
		Counterparty46__3.Counterparty46__3Builder setIdTp(PartyIdentification248Choice__3 idTp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("idTp"), processor, PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder.class, getIdTp());
		}
		

		Counterparty46__3.Counterparty46__3Builder prune();
	}

	/*********************** Immutable Implementation of Counterparty46__3  ***********************/
	class Counterparty46__3Impl implements Counterparty46__3 {
		private final PartyIdentification248Choice__3 idTp;
		
		protected Counterparty46__3Impl(Counterparty46__3.Counterparty46__3Builder builder) {
			this.idTp = ofNullable(builder.getIdTp()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("idTp")
		public PartyIdentification248Choice__3 getIdTp() {
			return idTp;
		}
		
		@Override
		public Counterparty46__3 build() {
			return this;
		}
		
		@Override
		public Counterparty46__3.Counterparty46__3Builder toBuilder() {
			Counterparty46__3.Counterparty46__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Counterparty46__3.Counterparty46__3Builder builder) {
			ofNullable(getIdTp()).ifPresent(builder::setIdTp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty46__3 _that = getType().cast(o);
		
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
			return "Counterparty46__3 {" +
				"idTp=" + this.idTp +
			'}';
		}
	}

	/*********************** Builder Implementation of Counterparty46__3  ***********************/
	class Counterparty46__3BuilderImpl implements Counterparty46__3.Counterparty46__3Builder {
	
		protected PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder idTp;
		
		@Override
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("idTp")
		public PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder getIdTp() {
			return idTp;
		}
		
		@Override
		public PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder getOrCreateIdTp() {
			PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder result;
			if (idTp!=null) {
				result = idTp;
			}
			else {
				result = idTp = PartyIdentification248Choice__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("idTp")
		@Override
		public Counterparty46__3.Counterparty46__3Builder setIdTp(PartyIdentification248Choice__3 _idTp) {
			this.idTp = _idTp == null ? null : _idTp.toBuilder();
			return this;
		}
		
		@Override
		public Counterparty46__3 build() {
			return new Counterparty46__3.Counterparty46__3Impl(this);
		}
		
		@Override
		public Counterparty46__3.Counterparty46__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty46__3.Counterparty46__3Builder prune() {
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
		public Counterparty46__3.Counterparty46__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Counterparty46__3.Counterparty46__3Builder o = (Counterparty46__3.Counterparty46__3Builder) other;
			
			merger.mergeRosetta(getIdTp(), o.getIdTp(), this::setIdTp);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty46__3 _that = getType().cast(o);
		
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
			return "Counterparty46__3Builder {" +
				"idTp=" + this.idTp +
			'}';
		}
	}
}
