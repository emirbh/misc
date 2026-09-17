package fpml.consolidated.msg;

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
import fpml.consolidated.msg.meta.ImplementationSpecificationMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A version of a specification document used by the message generator to format the document.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A version of a specification document used by the message generator to format the document.
 *
 */
@RosettaDataType(value="ImplementationSpecification", builder=ImplementationSpecification.ImplementationSpecificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ImplementationSpecification", model="fpml", builder=ImplementationSpecification.ImplementationSpecificationBuilderImpl.class, version="2.1.1")
public interface ImplementationSpecification extends RosettaModelObject {

	ImplementationSpecificationMeta metaData = new ImplementationSpecificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	ImplementationSpecificationVersion getVersion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	ZonedDateTime getDate();

	/*********************** Build Methods  ***********************/
	ImplementationSpecification build();
	
	ImplementationSpecification.ImplementationSpecificationBuilder toBuilder();
	
	static ImplementationSpecification.ImplementationSpecificationBuilder builder() {
		return new ImplementationSpecification.ImplementationSpecificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ImplementationSpecification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ImplementationSpecification> getType() {
		return ImplementationSpecification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("version"), processor, ImplementationSpecificationVersion.class, getVersion());
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ImplementationSpecificationBuilder extends ImplementationSpecification, RosettaModelObjectBuilder {
		ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder getOrCreateVersion();
		@Override
		ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder getVersion();
		ImplementationSpecification.ImplementationSpecificationBuilder setName(String name);
		ImplementationSpecification.ImplementationSpecificationBuilder setVersion(ImplementationSpecificationVersion version);
		ImplementationSpecification.ImplementationSpecificationBuilder setDate(ZonedDateTime date);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("version"), processor, ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder.class, getVersion());
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		}
		

		ImplementationSpecification.ImplementationSpecificationBuilder prune();
	}

	/*********************** Immutable Implementation of ImplementationSpecification  ***********************/
	class ImplementationSpecificationImpl implements ImplementationSpecification {
		private final String name;
		private final ImplementationSpecificationVersion version;
		private final ZonedDateTime date;
		
		protected ImplementationSpecificationImpl(ImplementationSpecification.ImplementationSpecificationBuilder builder) {
			this.name = builder.getName();
			this.version = ofNullable(builder.getVersion()).map(f->f.build()).orElse(null);
			this.date = builder.getDate();
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("version")
		public ImplementationSpecificationVersion getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		public ImplementationSpecification build() {
			return this;
		}
		
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder toBuilder() {
			ImplementationSpecification.ImplementationSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ImplementationSpecification.ImplementationSpecificationBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getDate()).ifPresent(builder::setDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ImplementationSpecification _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ImplementationSpecification {" +
				"name=" + this.name + ", " +
				"version=" + this.version + ", " +
				"date=" + this.date +
			'}';
		}
	}

	/*********************** Builder Implementation of ImplementationSpecification  ***********************/
	class ImplementationSpecificationBuilderImpl implements ImplementationSpecification.ImplementationSpecificationBuilder {
	
		protected String name;
		protected ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder version;
		protected ZonedDateTime date;
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("version")
		public ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder getVersion() {
			return version;
		}
		
		@Override
		public ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder getOrCreateVersion() {
			ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder result;
			if (version!=null) {
				result = version;
			}
			else {
				result = version = ImplementationSpecificationVersion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("version")
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder setVersion(ImplementationSpecificationVersion _version) {
			this.version = _version == null ? null : _version.toBuilder();
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@Override
		public ImplementationSpecification build() {
			return new ImplementationSpecification.ImplementationSpecificationImpl(this);
		}
		
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder prune() {
			if (version!=null && !version.prune().hasData()) version = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getVersion()!=null && getVersion().hasData()) return true;
			if (getDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ImplementationSpecification.ImplementationSpecificationBuilder o = (ImplementationSpecification.ImplementationSpecificationBuilder) other;
			
			merger.mergeRosetta(getVersion(), o.getVersion(), this::setVersion);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ImplementationSpecification _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ImplementationSpecificationBuilder {" +
				"name=" + this.name + ", " +
				"version=" + this.version + ", " +
				"date=" + this.date +
			'}';
		}
	}
}
