package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.SecurityIdentification46__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SecurityIdentification46__3", builder=SecurityIdentification46__3.SecurityIdentification46__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SecurityIdentification46__3", model="iso20022", builder=SecurityIdentification46__3.SecurityIdentification46__3BuilderImpl.class, version="${project.version}")
public interface SecurityIdentification46__3 extends RosettaModelObject {

	SecurityIdentification46__3Meta metaData = new SecurityIdentification46__3Meta();

	/*********************** Getter Methods  ***********************/
	UniqueProductIdentifier2Choice__2 getUnqPdctIdr();

	/*********************** Build Methods  ***********************/
	SecurityIdentification46__3 build();
	
	SecurityIdentification46__3.SecurityIdentification46__3Builder toBuilder();
	
	static SecurityIdentification46__3.SecurityIdentification46__3Builder builder() {
		return new SecurityIdentification46__3.SecurityIdentification46__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecurityIdentification46__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecurityIdentification46__3> getType() {
		return SecurityIdentification46__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("unqPdctIdr"), processor, UniqueProductIdentifier2Choice__2.class, getUnqPdctIdr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityIdentification46__3Builder extends SecurityIdentification46__3, RosettaModelObjectBuilder {
		UniqueProductIdentifier2Choice__2.UniqueProductIdentifier2Choice__2Builder getOrCreateUnqPdctIdr();
		@Override
		UniqueProductIdentifier2Choice__2.UniqueProductIdentifier2Choice__2Builder getUnqPdctIdr();
		SecurityIdentification46__3.SecurityIdentification46__3Builder setUnqPdctIdr(UniqueProductIdentifier2Choice__2 unqPdctIdr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("unqPdctIdr"), processor, UniqueProductIdentifier2Choice__2.UniqueProductIdentifier2Choice__2Builder.class, getUnqPdctIdr());
		}
		

		SecurityIdentification46__3.SecurityIdentification46__3Builder prune();
	}

	/*********************** Immutable Implementation of SecurityIdentification46__3  ***********************/
	class SecurityIdentification46__3Impl implements SecurityIdentification46__3 {
		private final UniqueProductIdentifier2Choice__2 unqPdctIdr;
		
		protected SecurityIdentification46__3Impl(SecurityIdentification46__3.SecurityIdentification46__3Builder builder) {
			this.unqPdctIdr = ofNullable(builder.getUnqPdctIdr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("unqPdctIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unqPdctIdr")
		public UniqueProductIdentifier2Choice__2 getUnqPdctIdr() {
			return unqPdctIdr;
		}
		
		@Override
		public SecurityIdentification46__3 build() {
			return this;
		}
		
		@Override
		public SecurityIdentification46__3.SecurityIdentification46__3Builder toBuilder() {
			SecurityIdentification46__3.SecurityIdentification46__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityIdentification46__3.SecurityIdentification46__3Builder builder) {
			ofNullable(getUnqPdctIdr()).ifPresent(builder::setUnqPdctIdr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityIdentification46__3 _that = getType().cast(o);
		
			if (!Objects.equals(unqPdctIdr, _that.getUnqPdctIdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unqPdctIdr != null ? unqPdctIdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityIdentification46__3 {" +
				"unqPdctIdr=" + this.unqPdctIdr +
			'}';
		}
	}

	/*********************** Builder Implementation of SecurityIdentification46__3  ***********************/
	class SecurityIdentification46__3BuilderImpl implements SecurityIdentification46__3.SecurityIdentification46__3Builder {
	
		protected UniqueProductIdentifier2Choice__2.UniqueProductIdentifier2Choice__2Builder unqPdctIdr;
		
		@Override
		@RosettaAttribute("unqPdctIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unqPdctIdr")
		public UniqueProductIdentifier2Choice__2.UniqueProductIdentifier2Choice__2Builder getUnqPdctIdr() {
			return unqPdctIdr;
		}
		
		@Override
		public UniqueProductIdentifier2Choice__2.UniqueProductIdentifier2Choice__2Builder getOrCreateUnqPdctIdr() {
			UniqueProductIdentifier2Choice__2.UniqueProductIdentifier2Choice__2Builder result;
			if (unqPdctIdr!=null) {
				result = unqPdctIdr;
			}
			else {
				result = unqPdctIdr = UniqueProductIdentifier2Choice__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("unqPdctIdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unqPdctIdr")
		@Override
		public SecurityIdentification46__3.SecurityIdentification46__3Builder setUnqPdctIdr(UniqueProductIdentifier2Choice__2 _unqPdctIdr) {
			this.unqPdctIdr = _unqPdctIdr == null ? null : _unqPdctIdr.toBuilder();
			return this;
		}
		
		@Override
		public SecurityIdentification46__3 build() {
			return new SecurityIdentification46__3.SecurityIdentification46__3Impl(this);
		}
		
		@Override
		public SecurityIdentification46__3.SecurityIdentification46__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityIdentification46__3.SecurityIdentification46__3Builder prune() {
			if (unqPdctIdr!=null && !unqPdctIdr.prune().hasData()) unqPdctIdr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnqPdctIdr()!=null && getUnqPdctIdr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityIdentification46__3.SecurityIdentification46__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityIdentification46__3.SecurityIdentification46__3Builder o = (SecurityIdentification46__3.SecurityIdentification46__3Builder) other;
			
			merger.mergeRosetta(getUnqPdctIdr(), o.getUnqPdctIdr(), this::setUnqPdctIdr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityIdentification46__3 _that = getType().cast(o);
		
			if (!Objects.equals(unqPdctIdr, _that.getUnqPdctIdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unqPdctIdr != null ? unqPdctIdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityIdentification46__3Builder {" +
				"unqPdctIdr=" + this.unqPdctIdr +
			'}';
		}
	}
}
