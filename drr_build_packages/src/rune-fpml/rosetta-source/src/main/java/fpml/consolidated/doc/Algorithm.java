package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.AlgorithmMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="Algorithm", builder=Algorithm.AlgorithmBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Algorithm", model="fpml", builder=Algorithm.AlgorithmBuilderImpl.class, version="2.1.1")
public interface Algorithm extends RosettaModelObject {

	AlgorithmMeta metaData = new AlgorithmMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The name of the algorithm.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the algorithm.
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The category of the function of the algorithm. The related individual performs the role specified in this field for the base party. For example, if the role is "Trader", the related person acts acts or acted as the base party's trader.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The category of the function of the algorithm. The related individual performs the role specified in this field for the base party. For example, if the role is "Trader", the related person acts acts or acted as the base party's trader.
	 *
	 */
	AlgorithmRole getRole();

	/*********************** Build Methods  ***********************/
	Algorithm build();
	
	Algorithm.AlgorithmBuilder toBuilder();
	
	static Algorithm.AlgorithmBuilder builder() {
		return new Algorithm.AlgorithmBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Algorithm> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Algorithm> getType() {
		return Algorithm.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("role"), processor, AlgorithmRole.class, getRole());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AlgorithmBuilder extends Algorithm, RosettaModelObjectBuilder {
		AlgorithmRole.AlgorithmRoleBuilder getOrCreateRole();
		@Override
		AlgorithmRole.AlgorithmRoleBuilder getRole();
		Algorithm.AlgorithmBuilder setName(String name);
		Algorithm.AlgorithmBuilder setRole(AlgorithmRole role);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("role"), processor, AlgorithmRole.AlgorithmRoleBuilder.class, getRole());
		}
		

		Algorithm.AlgorithmBuilder prune();
	}

	/*********************** Immutable Implementation of Algorithm  ***********************/
	class AlgorithmImpl implements Algorithm {
		private final String name;
		private final AlgorithmRole role;
		
		protected AlgorithmImpl(Algorithm.AlgorithmBuilder builder) {
			this.name = builder.getName();
			this.role = ofNullable(builder.getRole()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("role")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("role")
		public AlgorithmRole getRole() {
			return role;
		}
		
		@Override
		public Algorithm build() {
			return this;
		}
		
		@Override
		public Algorithm.AlgorithmBuilder toBuilder() {
			Algorithm.AlgorithmBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Algorithm.AlgorithmBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getRole()).ifPresent(builder::setRole);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Algorithm _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Algorithm {" +
				"name=" + this.name + ", " +
				"role=" + this.role +
			'}';
		}
	}

	/*********************** Builder Implementation of Algorithm  ***********************/
	class AlgorithmBuilderImpl implements Algorithm.AlgorithmBuilder {
	
		protected String name;
		protected AlgorithmRole.AlgorithmRoleBuilder role;
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("role")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("role")
		public AlgorithmRole.AlgorithmRoleBuilder getRole() {
			return role;
		}
		
		@Override
		public AlgorithmRole.AlgorithmRoleBuilder getOrCreateRole() {
			AlgorithmRole.AlgorithmRoleBuilder result;
			if (role!=null) {
				result = role;
			}
			else {
				result = role = AlgorithmRole.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("name")
		@Override
		public Algorithm.AlgorithmBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("role")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("role")
		@Override
		public Algorithm.AlgorithmBuilder setRole(AlgorithmRole _role) {
			this.role = _role == null ? null : _role.toBuilder();
			return this;
		}
		
		@Override
		public Algorithm build() {
			return new Algorithm.AlgorithmImpl(this);
		}
		
		@Override
		public Algorithm.AlgorithmBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Algorithm.AlgorithmBuilder prune() {
			if (role!=null && !role.prune().hasData()) role = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getRole()!=null && getRole().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Algorithm.AlgorithmBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Algorithm.AlgorithmBuilder o = (Algorithm.AlgorithmBuilder) other;
			
			merger.mergeRosetta(getRole(), o.getRole(), this::setRole);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Algorithm _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AlgorithmBuilder {" +
				"name=" + this.name + ", " +
				"role=" + this.role +
			'}';
		}
	}
}
